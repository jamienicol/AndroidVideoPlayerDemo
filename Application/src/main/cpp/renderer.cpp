//
// Created by Jamie Robinson-Nicol on 31/05/2024.
//

#include "renderer.h"

#include <android/log.h>
#include <GLES3/gl3.h>

static const char* const LOGTAG = "Renderer";

void Renderer::onSurfaceCreated() {
    glClearColor(0.0f, 1.0f, 1.0f, 1.0f);
}

void Renderer::onSurfaceChanged(int width, int height) {
    __android_log_print(ANDROID_LOG_DEBUG, LOGTAG,
                        "Renderer::onSurfaceChanged() %dx%d",
                        width, height);
}

void Renderer::onDrawFrame() {
    glClear(GL_COLOR_BUFFER_BIT);
}
