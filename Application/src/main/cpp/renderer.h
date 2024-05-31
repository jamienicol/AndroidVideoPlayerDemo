//
// Created by Jamie Robinson-Nicol on 31/05/2024.
//

#ifndef ANDROIDVIDEOPLAYERDEMO_RENDERER_H
#define ANDROIDVIDEOPLAYERDEMO_RENDERER_H


class Renderer {
public:
    void onSurfaceCreated();
    void onSurfaceChanged(int width, int height);
    void onDrawFrame();
};


#endif //ANDROIDVIDEOPLAYERDEMO_RENDERER_H
