package com.edd.qtv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TvLogDetalleDatabaseHandler extends SQLiteOpenHelper {
	
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "quitTv";
 
    // Contacts table name
    private static final String TABLE_TV_LOG = "tv_log_detalles";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_HORAS_TV = "horas_tv";
    private static final String KEY_HORA_INICIO = "hora_inicio";
    private static final String KEY_HORA_FIN = "hora_fin";

	public TvLogDetalleDatabaseHandler(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TV_LOG_TABLE = "CREATE TABLE " + TABLE_TV_LOG + "(" +
				KEY_ID + " INTEGER PRIMARY KEY, " + 
				KEY_HORAS_TV + " INTEGER, " + 
				KEY_HORA_INICIO + " DATETIME, " + 
				KEY_HORA_FIN + " DATETIME )";
		
		db.execSQL(CREATE_TV_LOG_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROM TABLE IF EXIST " + TABLE_TV_LOG);
		
		onCreate(db);
	}
}
