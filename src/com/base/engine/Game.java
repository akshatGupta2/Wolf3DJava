package com.base.engine;

import java.util.ArrayList;

import javax.management.remote.TargetedNotification;

public class Game 
{
	Bitmap level;
	Shader shader;
	Material text;
	Mesh mesh;
	Transform tfm;

	// dimension of each cube
	private static final float SPOT_WIDTH = 1.0f;
	private static final float SPOT_HEIGHT = 1.0f;
	private static final float SPOT_LENGTH = 1.0f;

	public Game()
	{
		level = new Bitmap("lvl1.png");
		for (int i = 0; i < level.getWidth(); i++) {
			for (int j = 0; j < level.getHeight(); j++) {
				System.out.print(level.getPixel(i, j) + ", ");
			}
			System.out.println();
		}
		shader = BasicShader.getInstance();
		text = new Material(new Texture("test.png"));
		// we comment this as we need to load vertices from level and not some randomvalues
		Vertex[] vertices = new Vertex[] { new Vertex(new Vector3f(0, 0, 0), new Vector2f(0, 0)),
				new Vertex(new Vector3f(0, 1, 0), new Vector2f(0, 1)),
				new Vertex(new Vector3f(1, 1, 0), new Vector2f(1, 1)),
				new Vertex(new Vector3f(1, 0, 0), new Vector2f(1, 0)) };
				int[] indices = new int[] {0,1,2,
										   0,2,3};
			// 	ArrayList<Vertex> vertices = new ArrayList<>();
			// 	ArrayList<Integer> indices = new ArrayList<>();

			// for (int i = 0; i < level.getWidth(); i++) {
			// 	for (int j = 0; j < level.getHeight(); j++) {
			// 		vertices.add(new Vertex(new Vector3f(0, 0, 0), new Vector2f(0, 0)));
			// 		vertices.add(new Vertex(new Vector3f(0, 0, 0), new Vector2f(0, 0)));
			// 		vertices.add(new Vertex(new Vector3f(0, 0, 0), new Vector2f(0, 0)));
			// 		vertices.add(new Vertex(new Vector3f(0, 0, 0), new Vector2f(0, 0)));
			// 	}
			// }

			// 	Vertex[] varr = new Vertex[vertices.size()];
			// 	vertices.toArray(varr);
			// 	Integer[] indarr = new Integer[indices.size()];
			// 	indices.toArray(indarr);

				mesh = new Mesh(vertices, indices);
				tfm = new Transform();
				Transform.setCamera(new Camera());
				Transform.setProjection(70, Window.getWidth(), Window.getHeight(), 0.01f, 1000);;
	} 
	
	public void input()
	{
		Transform.getCamera().input();
	}
	
	public void update()
	{
	}
	
	public void render()
	{
		shader.bind();
		shader.updateUniforms(tfm.getTransformation(), tfm.getProjectedTransformation(), text);
		mesh.draw();
	}
}
