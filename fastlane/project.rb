
platform :project do
  lane :setup do
    sh <<-EOS
        cd ../

        # setup private/ directory
        if [ ! -e "./private" ]; then
          echo "Install   [private/]"
          mkdir "./private"
          cp -rf .configs/private/** ./private/
        else
          echo "Installed [private/]"
        fi

        # setup secret files
        # gsutil cp -R "gs://#{$secret_files_bucket}/*" .configs/secrets/
        # cp -f .configs/secrets/google-services.json app/src/main/google-services.json
    EOS
  end
end
