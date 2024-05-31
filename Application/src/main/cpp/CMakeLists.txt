
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html.
# For more examples on how to use CMake, see https://github.com/android/ndk-samples.

# Sets the minimum CMake version required for this project.
cmake_minimum_required(VERSION 3.22.1)

# Declares the project name. The project name can be accessed via ${ PROJECT_NAME},
# Since this is the top level CMakeLists.txt, the project name is also accessible
# with ${CMAKE_PROJECT_NAME} (both CMake variables are in-sync within the top level
# build script scope).
project("video_demo")

# Locate SWIG
find_package(SWIG REQUIRED)
include(${SWIG_USE_FILE})

# Specify the SWIG interface file
set(SWIG_I ${CMAKE_SOURCE_DIR}/renderer.i)

# Specify the output directory for the generated files
set(CMAKE_SWIG_OUTDIR ${CMAKE_SOURCE_DIR}/../swig)

# Create the SWIG module
set_source_files_properties(${SWIG_I} PROPERTIES CPLUSPLUS ON)
set_source_files_properties(${SWIG_I} PROPERTIES SWIG_FLAGS "-package;uk.jamiern.videoplayerdemo")

# Include the generated files
include_directories(${CMAKE_SWIG_OUTDIR})
include_directories(${CMAKE_SOURCE_DIR})

swig_add_library(swig LANGUAGE java TYPE STATIC SOURCES ${SWIG_I})

add_library(${CMAKE_PROJECT_NAME} SHARED
    # List C/C++ source files with relative paths to this CMakeLists.txt.
    renderer.cpp
    ../swig/rendererJAVA_wrap.cxx)

# Specifies libraries CMake should link to your target library. You
# can link libraries from various origins, such as libraries defined in this
# build script, prebuilt third-party libraries, or Android system libraries.
target_link_libraries(${CMAKE_PROJECT_NAME}
    # List libraries link to the target library
    android
    log
    EGL
    GLESv2
    GLESv3)
