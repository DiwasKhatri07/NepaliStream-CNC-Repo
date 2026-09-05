package com.cncverse;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SubscriptionManagerPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SubscriptionManager/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/cncverse/SubscriptionManagerPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "Companion", "SubscriptionManager_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SubscriptionManagerPlugin extends Plugin {

    @NotNull
    public static final String KEY_EMAIL = "email";

    @NotNull
    public static final String KEY_EXPIRES_AT = "expires_at";

    @NotNull
    public static final String KEY_LICENSE_TOKEN = "license_token";

    @NotNull
    public static final String KEY_MODE = "mode";

    @NotNull
    public static final String KEY_PLAN = "plan";

    @NotNull
    public static final String PREFS_NAME = "CNCVerseSubscription";

    public void load(@NotNull Context context) {
        final SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity activity = (AppCompatActivity) context;
        setOpenSettings(new Function1() { // from class: com.cncverse.SubscriptionManagerPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return SubscriptionManagerPlugin.load$lambda$0(this.f$0, prefs, activity, (Context) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0(SubscriptionManagerPlugin this$0, SharedPreferences $prefs, AppCompatActivity $activity, Context it) {
        SubscriptionManagerSettings frag = new SubscriptionManagerSettings(this$0, $prefs);
        frag.show($activity.getSupportFragmentManager(), "SubscriptionManager");
        return Unit.INSTANCE;
    }
}
