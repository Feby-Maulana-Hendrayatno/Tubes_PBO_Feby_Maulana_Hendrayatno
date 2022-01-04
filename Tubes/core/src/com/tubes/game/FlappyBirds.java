package com.tubes.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tubes.game.states.GameStateManager;
import com.tubes.game.states.MenuState;

public class FlappyBirds extends ApplicationAdapter {
	public static final int WIDTH = 480; //panjang layar
	public static final int HEIGHT = 800; //tinggi layar

	public static final String TITLE = "Flappy Bird";

	//buat looping di state manager
	//mendeklarasikan class GameStateManager dengan gsm
	private GameStateManager gsm;

	private SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();

		ScreenUtils.clear(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
