package com.Kartoons;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KartoonsPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\u0002\b\n¨\u0006\t"}, d2 = {"Lcom/Kartoons/KartoonsPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "Companion", "Kartoons", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class KartoonsPlugin extends Plugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String cfCookies = "";

    @NotNull
    private static String cfUserAgent = "";
    private static boolean cfWebviewEnabled = true;

    @NotNull
    private static String cfCookieHost = "";

    @NotNull
    private static String authToken = "";

    /* JADX INFO: compiled from: KartoonsPlugin.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/Kartoons/KartoonsPlugin$Companion;", "", "<init>", "()V", "cfCookies", "", "getCfCookies", "()Ljava/lang/String;", "setCfCookies", "(Ljava/lang/String;)V", "cfUserAgent", "getCfUserAgent", "setCfUserAgent", "cfWebviewEnabled", "", "getCfWebviewEnabled", "()Z", "setCfWebviewEnabled", "(Z)V", "cfCookieHost", "getCfCookieHost", "setCfCookieHost", "authToken", "getAuthToken", "setAuthToken", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getCfCookies() {
            return KartoonsPlugin.cfCookies;
        }

        public final void setCfCookies(@NotNull String str) {
            KartoonsPlugin.cfCookies = str;
        }

        @NotNull
        public final String getCfUserAgent() {
            return KartoonsPlugin.cfUserAgent;
        }

        public final void setCfUserAgent(@NotNull String str) {
            KartoonsPlugin.cfUserAgent = str;
        }

        public final boolean getCfWebviewEnabled() {
            return KartoonsPlugin.cfWebviewEnabled;
        }

        public final void setCfWebviewEnabled(boolean z) {
            KartoonsPlugin.cfWebviewEnabled = z;
        }

        @NotNull
        public final String getCfCookieHost() {
            return KartoonsPlugin.cfCookieHost;
        }

        public final void setCfCookieHost(@NotNull String str) {
            KartoonsPlugin.cfCookieHost = str;
        }

        @NotNull
        public final String getAuthToken() {
            return KartoonsPlugin.authToken;
        }

        public final void setAuthToken(@NotNull String str) {
            KartoonsPlugin.authToken = str;
        }
    }

    public void load(@NotNull Context context) {
        final SharedPreferences sharedPref = context.getSharedPreferences("Kartoons", 0);
        String string = sharedPref.getString("cf_cookies", "");
        if (string == null) {
            string = "";
        }
        cfCookies = string;
        String string2 = sharedPref.getString("cf_user_agent", "");
        if (string2 == null) {
            string2 = "";
        }
        cfUserAgent = string2;
        cfWebviewEnabled = sharedPref.getBoolean("cf_webview_enabled", true);
        String string3 = sharedPref.getString("auth_token", "");
        authToken = string3 != null ? string3 : "";
        String token = !StringsKt.isBlank(authToken) ? authToken : null;
        registerMainAPI(new Kartoons(token));
        setOpenSettings(new Function1() { // from class: com.Kartoons.KartoonsPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return KartoonsPlugin.load$lambda$0(this.f$0, sharedPref, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(KartoonsPlugin this$0, SharedPreferences $sharedPref, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity activity = (AppCompatActivity) ctx;
        SettingsFragment frag = new SettingsFragment(this$0, $sharedPref);
        frag.show(activity.getSupportFragmentManager(), "Frag");
        return Unit.INSTANCE;
    }
}
