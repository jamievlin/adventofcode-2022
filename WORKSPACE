load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_kotlin_version = "1.6.0"

rules_kotlin_sha = "a57591404423a52bd6b18ebba7979e8cd2243534736c5c94d35c89718ea38f94"

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = rules_kotlin_sha,
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v%s/rules_kotlin_release.tgz" % rules_kotlin_version],
)

# config java repository
load("@bazel_tools//tools/jdk:remote_java_repository.bzl", "remote_java_repository")

remote_java_repository(
    name = "temurin",
    exec_compatible_with = [
        "@platforms//os:windows",
    ],
    prefix = "temurin",
    sha256 = "3cdcd859c8421a0681e260dc4fbf46b37fb1211f47beb2326a00398ecc52fde0",
    strip_prefix = "jdk-17.0.5+8",
    urls = ["https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.5%2B8/OpenJDK17U-jdk_x64_windows_hotspot_17.0.5_8.zip"],
    version = "17",
)

remote_java_repository(
    name = "temurin_linux",
    exec_compatible_with = [
        "@platforms//os:linux",
    ],
    prefix = "temurin",
    sha256 = "482180725ceca472e12a8e6d1a4af23d608d78287a77d963335e2a0156a020af",
    strip_prefix = "jdk-17.0.5+8",
    urls = ["https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.5%2B8/OpenJDK17U-jdk_x64_linux_hotspot_17.0.5_8.tar.gz"],
    version = "17",
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories", "kotlinc_version")

kotlin_repositories(
    compiler_release = kotlinc_version(
        release = "1.7.21",  # just the numeric version
        sha256 = "8412b31b808755f0c0d336dbb8c8443fa239bf32ddb3cdb81b305b25f0ad279e",
    ),
)  # if you want the default. Otherwise see custom kotlinc distribution below

register_toolchains("//toolchains:kotlin_toolchain")
