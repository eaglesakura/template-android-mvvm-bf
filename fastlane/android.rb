
platform :android do

  lane :clean do
    gradle(task: "clean")
  end

  lane :test do
    $test_targets.each do |project|
        gradle(task: "--stop")
        android_test("--parallel :#{project}:testDebug", "#{project}")
        android_test(":#{project}:connectedDebugAndroidTest", "#{project}")
    end
    gradle(task: "--stop")
  end

  lane :lint do
    gradle(task: "--stop")
    gradle(task: "compileDebugSources")
    $test_targets.each do |project|
        android_test(":#{project}:lint", "#{project}")
    end

    android_test(":app:lint", "app")
    gradle(task: "--stop")
  end

  lane :local_test do
    gradle(task: "--stop")
    gradle(task: "--parallel compileDebugSources")
    $test_targets.each do |project|
        android_test("--parallel :#{project}:testDebug", "#{project}")
        android_test("--parallel :#{project}:assembleDebugAndroidTest", "#{project}")
    end
  end

  lane :assemble do
    gradle(task: "--stop")
    gradle(task: "clean")

    $app_flavors.each do |flavor|
        gradle(task: "--parallel :app:assemble#{flavor}Debug")
        gradle(task: "--parallel :app:assemble#{flavor}Release")
        gradle(task: "--parallel :app:bundle#{flavor}Release")
    end

    # collect
    copy_artifacts(
      target_path: "artifacts/app",
      artifacts: ["app/build/outputs"],
    )
    gradle(task: "--stop")
  end
end


# single test with archive.
def android_test(task, path)
    begin
        gradle(task: "#{task}")
        copy_artifacts(
          target_path: "artifacts/#{path}",
          artifacts: ["#{path}/build/reports"],
        )
    rescue => e
        copy_artifacts(
          target_path: "artifacts/#{path}",
          artifacts: ["#{path}/build/reports"],
        )
        Kernel.abort
    end
end

# single assemble with archive.
def android_assemble(task, path)
    gradle(task: "#{task}")
    copy_artifacts(
      target_path: "artifacts/#{path}",
      artifacts: ["#{path}/build/outputs"],
    )
end
