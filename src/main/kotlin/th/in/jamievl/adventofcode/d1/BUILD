load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "d1",
    srcs = glob(["*.kt"]),
    resources = ["//src/main/resources/d1:d1_input"],
)

java_binary(
    name = "d1_bin",
    runtime_deps = ["d1"],
    main_class = "th.in.jamievl.adventofcode.d1.Day1Kt",
)