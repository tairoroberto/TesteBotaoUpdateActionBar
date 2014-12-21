package br.com.tairoroberto.testebotaoupdateactionbar;

import com.actionbarsherlock.view.MenuItem;

import android.app.Activity;

public class ProgressBarMenu {
	
	public static void atualizar(final Activity activity, final MenuItem menuItem) {
		
		menuItem.setActionView(R.layout.progressbar_menu);
		new Thread(){
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				activity.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// Depois de aguardar os três segundos, tiramos o icone e colocamos de novo
						menuItem.setActionView(null);
						menuItem.setIcon(android.R.drawable.ic_menu_rotate);						
					}
				});
			}
		}.start();
	}
}
