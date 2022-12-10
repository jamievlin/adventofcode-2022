load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "d2",
    srcs = glob(["*.kt"]),
    resources = ["//src/main/resources/d2:d2_input"],
    deps = ["//src/main/kotlin/th/in/jamievl/adventofcode/common"],
)

java_binary(
    name = "d2_bin",
    main_class = "th.in.jamievl.adventofcode.d2.Day2Kt",
    runtime_deps = ["d2"],
)
