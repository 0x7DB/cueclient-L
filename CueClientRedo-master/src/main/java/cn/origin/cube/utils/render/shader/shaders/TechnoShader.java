package cn.origin.cube.utils.render.shader.shaders;

import cn.origin.cube.utils.render.shader.FramebufferShader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL20;

public class TechnoShader extends FramebufferShader {
    public static TechnoShader TECHNO_SHADER;
    public float time;
    public float timeMult = 0.01f;

    public TechnoShader() {
        super("techno.frag");
    }

    @Override
    public void setupUniforms() {
        this.setupUniform("resolution");
        this.setupUniform("time");
    }

    @Override
    public void updateUniforms() {
        GL20.glUniform2f(this.getUniform("resolution"), (float)new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth(), (float)new ScaledResolution(Minecraft.getMinecraft()).getScaledHeight());
        GL20.glUniform1f(this.getUniform("time"), time);
        time += timeMult * animationSpeed;
    }

    static {
        TECHNO_SHADER = new TechnoShader();
    }
}