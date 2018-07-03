package pack.versione_1;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GestionaleDB.db";
    public static final String TABLE1_NAME = "t_serra";
    public static final String COL_SERRA_1 = "nome_serra";
    public static final String COL_SERRA_2 = "zona";
    public static final String COL_SERRA_3 = "m2";
    public static final String COL_SERRA_4 = "coltura";
    public static final String COL_SERRA_5 = "varieta";
    public static final String COL_SERRA_6 = "piante_m2";
    public static final String COL_SERRA_7 = "data_trapianto";
    public static final String COL_SERRA_8 = "litri_ora_entrata";
    public static final String COL_SERRA_9 = "litri_ora_sgrondo";
    public static final String COL_SERRA_10 = "target_ec";

    public DatabaseHelper(Context context) {
        super (context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE1_NAME +
                "(nome_serra nvarchar 20 primary key,"+
                "zona nvarchar 20 not null,m2 int not null, " +
                "coltura nvarchar 20 not null," +
                "varieta nvarchar 20 not null," +
                "piante_m2 int not null," +
                "data_trapianto date not null," +
                "litri_ora_entrata float 20 not null," +
                "litri_ora_sgrondo float 20 not null," +
                "target_ec int not null)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
