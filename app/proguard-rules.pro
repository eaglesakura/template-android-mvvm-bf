-dontwarn **
-keep class com.deploygate.** { *; }

# Basic settings
-keepnames class * extends android.os.Parcelable
-keepnames class androidx.** { *; }
-keepnames class android.** { *; }
-keep public class * extends androidx.versionedparcelable.VersionedParcelable {
  <init>();
}
-keep public class * extends androidx.lifecycle.ViewModel {
  <init>(***);
}

-dontwarn com.eaglesakura.**

# Crashlytics
# https://firebase.google.com/docs/crashlytics/get-deobfuscated-reports#android
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

# OkHttp setting.
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
