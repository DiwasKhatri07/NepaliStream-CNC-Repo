package com.horis.cncverse;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NetflixMirrorStorage.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u001c\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\fJ\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\fJ\b\u0010\u001a\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/horis/cncverse/NetflixMirrorStorage;", "", "<init>", "()V", "context", "Landroid/content/Context;", "prefs", "Landroid/content/SharedPreferences;", "init", "", "saveCookie", "cookie", "", "getCookie", "Lkotlin/Pair;", "", "clearCookie", "saveUserToken", "ott", "token", "getUserToken", "saveApiBase", "apiBase", "getApiBase", "saveOtp", "otp", "getOtp", "saveCfCookie", "getCfCookie", "clearCfCookie", "clearAll", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NetflixMirrorStorage {

    @NotNull
    public static final NetflixMirrorStorage INSTANCE = new NetflixMirrorStorage();
    private static Context context;
    private static SharedPreferences prefs;

    private NetflixMirrorStorage() {
    }

    public final void init(@NotNull Context context2) {
        context = context2.getApplicationContext();
        prefs = context2.getSharedPreferences("NetflixMirrorPrefs", 0);
    }

    public final void saveCookie(@NotNull String cookie) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nf_cookie", cookie);
        editor.putLong("nf_cookie_timestamp", System.currentTimeMillis());
        editor.apply();
    }

    @NotNull
    public final Pair<String, Long> getCookie() {
        SharedPreferences sharedPreferences = prefs;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("nf_cookie", null);
        SharedPreferences sharedPreferences3 = prefs;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        return new Pair<>(string, Long.valueOf(sharedPreferences2.getLong("nf_cookie_timestamp", 0L)));
    }

    public final void clearCookie() {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("nf_cookie");
        editor.remove("nf_cookie_timestamp");
        editor.apply();
    }

    public final void saveUserToken(@NotNull String ott, @NotNull String token) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("usertoken_" + ott, token);
        editor.putLong("usertoken_timestamp_" + ott, System.currentTimeMillis());
        editor.apply();
    }

    @NotNull
    public final Pair<String, Long> getUserToken(@NotNull String ott) {
        SharedPreferences sharedPreferences = prefs;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("usertoken_" + ott, null);
        SharedPreferences sharedPreferences3 = prefs;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        return new Pair<>(string, Long.valueOf(sharedPreferences2.getLong("usertoken_timestamp_" + ott, 0L)));
    }

    public final void saveApiBase(@NotNull String apiBase) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("newtv_api_base", apiBase);
        editor.putLong("newtv_api_base_timestamp", System.currentTimeMillis());
        editor.apply();
    }

    @NotNull
    public final Pair<String, Long> getApiBase() {
        SharedPreferences sharedPreferences = prefs;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("newtv_api_base", null);
        SharedPreferences sharedPreferences3 = prefs;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        return new Pair<>(string, Long.valueOf(sharedPreferences2.getLong("newtv_api_base_timestamp", 0L)));
    }

    public final void saveOtp(@NotNull String otp) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("newtv_otp", otp);
        editor.apply();
    }

    @Nullable
    public final String getOtp() {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getString("newtv_otp", null);
    }

    public final void saveCfCookie(@NotNull String cookie) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cf_clearance", cookie);
        editor.putLong("cf_clearance_timestamp", System.currentTimeMillis());
        editor.apply();
    }

    @NotNull
    public final Pair<String, Long> getCfCookie() {
        SharedPreferences sharedPreferences = prefs;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("cf_clearance", null);
        SharedPreferences sharedPreferences3 = prefs;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        return new Pair<>(string, Long.valueOf(sharedPreferences2.getLong("cf_clearance_timestamp", 0L)));
    }

    public final void clearCfCookie() {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("cf_clearance");
        editor.remove("cf_clearance_timestamp");
        editor.apply();
    }

    public final void clearAll() {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        sharedPreferences.edit().clear().apply();
    }
}
