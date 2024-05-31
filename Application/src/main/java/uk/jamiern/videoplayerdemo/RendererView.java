package uk.jamiern.videoplayerdemo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RendererView extends GLSurfaceView {
    public RendererView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setEGLContextClientVersion(3);
        setRenderer(new MyRenderer());
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }

    private static class MyRenderer implements GLSurfaceView.Renderer {
        private uk.jamiern.videoplayerdemo.Renderer mRenderer = new uk.jamiern.videoplayerdemo.Renderer();

        @Override
        public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
            mRenderer.onSurfaceCreated();
        }

        @Override
        public void onSurfaceChanged(GL10 gl10, int width, int height) {
            mRenderer.onSurfaceChanged(width, height);
        }

        @Override
        public void onDrawFrame(GL10 gl10) {
            mRenderer.onDrawFrame();
        }
    }
}
