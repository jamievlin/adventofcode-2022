load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "d4",
    srcs = glob(["*.kt"]),
    resources = ["//src/main/resources/d4:d4_input"],
    deps = ["//src/main/kotlin/th/in/jamievl/adventofcode/common"],
)

java_binary(
    name = "d4_bin",
    main_class = "th.in.jamievl.adventofcode.d4.Day4Kt",
    runtime_deps = ["d4"],
)
