load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "d3",
    srcs = glob(["*.kt"]),
    resources = ["//src/main/resources/d3:d3_input"],
    deps = ["//src/main/kotlin/th/in/jamievl/adventofcode/common"],
)

java_binary(
    name = "d3_bin",
    main_class = "th.in.jamievl.adventofcode.d3.Day3Kt",
    runtime_deps = ["d3"],
)
