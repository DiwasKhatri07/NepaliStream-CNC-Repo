package com.cncverse;

import android.R;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SubscriptionManagerSettings.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SubscriptionManager/classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003J%\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0003J0\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010 H\u0003J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0002J\n\u0010&\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\rH\u0002J\u0018\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/cncverse/SubscriptionManagerSettings;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/cncverse/SubscriptionManagerPlugin;", "prefs", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/cncverse/SubscriptionManagerPlugin;Landroid/content/SharedPreferences;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "", "findViewByName", "T", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "bindViews", "refreshStatus", "modeBadge", "Landroid/widget/TextView;", "statusText", "planText", "tokenField", "capitalise", "str", "getClipboardText", "openBrowser", "url", "verifyToken", "Lcom/cncverse/SubscriptionManagerSettings$VerifyResult;", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "VerifyResult", "SubscriptionManager_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSubscriptionManagerSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionManagerSettings.kt\ncom/cncverse/SubscriptionManagerSettings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,285:1\n1#2:286\n*E\n"})
public final class SubscriptionManagerSettings extends BottomSheetDialogFragment {

    @NotNull
    private static final String API_URL = "https://cncverse-subscription-api.cncverse.workers.dev";

    @NotNull
    private static final String SIGNIN_URL = "https://cncverse-sub.pages.dev/signin.html";

    @NotNull
    private static final String SUBSCRIBE_URL = "https://cncverse-sub.pages.dev";

    @NotNull
    private final SubscriptionManagerPlugin plugin;

    @NotNull
    private final SharedPreferences prefs;

    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    public SubscriptionManagerSettings(@NotNull SubscriptionManagerPlugin plugin, @NotNull SharedPreferences prefs) {
        this.plugin = plugin;
        this.prefs = prefs;
    }

    @SuppressLint({"DiscouragedApi"})
    private final Drawable getDrawable(String name) {
        Resources resources = this.plugin.getResources();
        Integer id = resources != null ? Integer.valueOf(resources.getIdentifier(name, "drawable", "com.cncverse")) : null;
        if (id == null) {
            return null;
        }
        int it = id.intValue();
        Resources resources2 = this.plugin.getResources();
        if (resources2 == null) {
            return null;
        }
        return ResourcesCompat.getDrawable(resources2, it, (Resources.Theme) null);
    }

    @SuppressLint({"DiscouragedApi"})
    private final <T extends View> T findViewByName(View view, String str) {
        Resources resources = this.plugin.getResources();
        Integer numValueOf = resources != null ? Integer.valueOf(resources.getIdentifier(str, "id", "com.cncverse")) : null;
        if (numValueOf != null) {
            return (T) view.findViewById(numValueOf.intValue());
        }
        return null;
    }

    @SuppressLint({"DiscouragedApi"})
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Resources resources = this.plugin.getResources();
        Integer layoutId = resources != null ? Integer.valueOf(resources.getIdentifier("subscription_settings", "layout", "com.cncverse")) : null;
        if (layoutId == null) {
            return null;
        }
        int it = layoutId.intValue();
        Resources resources2 = this.plugin.getResources();
        return inflater.inflate((XmlPullParser) (resources2 != null ? resources2.getLayout(it) : null), container, false);
    }

    @RequiresApi(23)
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
    }

    public void onDestroyView() {
        super.onDestroyView();
        CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
    }

    @SuppressLint({"SetTextI18n"})
    private final void bindViews(View view) {
        final SubscriptionManagerSettings subscriptionManagerSettings;
        final TextView modeBadge = (TextView) findViewByName(view, "sm_mode_badge");
        final TextView modeBadge2 = (TextView) findViewByName(view, "sm_status_text");
        final TextView statusText = (TextView) findViewByName(view, "sm_plan_text");
        final TextView planText = (TextView) findViewByName(view, "sm_token_field");
        final Button pasteBtn = (Button) findViewByName(view, "sm_paste_btn");
        Button subscribeBtn = (Button) findViewByName(view, "sm_subscribe_btn");
        Button signinBtn = (Button) findViewByName(view, "sm_signin_btn");
        Button removeBtn = (Button) findViewByName(view, "sm_remove_btn");
        refreshStatus(modeBadge, modeBadge2, statusText, planText);
        if (pasteBtn != null) {
            subscriptionManagerSettings = this;
            pasteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.SubscriptionManagerSettings$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubscriptionManagerSettings.bindViews$lambda$0(this.f$0, pasteBtn, modeBadge, modeBadge2, statusText, planText, view2);
                }
            });
        } else {
            subscriptionManagerSettings = this;
        }
        if (subscribeBtn != null) {
            modeBadge = modeBadge;
            modeBadge2 = modeBadge2;
            statusText = statusText;
            planText = planText;
            subscribeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.SubscriptionManagerSettings$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.openBrowser(SubscriptionManagerSettings.SUBSCRIBE_URL);
                }
            });
        }
        if (signinBtn != null) {
            signinBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.SubscriptionManagerSettings$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubscriptionManagerSettings.bindViews$lambda$2(this.f$0, view2);
                }
            });
        }
        if (removeBtn != null) {
            removeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.SubscriptionManagerSettings$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubscriptionManagerSettings.bindViews$lambda$3(this.f$0, modeBadge, modeBadge2, statusText, planText, view2);
                }
            });
        }
        Button closeBtn = (Button) findViewByName(view, "sm_close_btn");
        if (closeBtn != null) {
            closeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.SubscriptionManagerSettings$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.dismiss();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindViews$lambda$0(SubscriptionManagerSettings this$0, Button $pasteBtn, TextView $modeBadge, TextView $statusText, TextView $planText, TextView $tokenField, View it) {
        String token = this$0.getClipboardText();
        String str = token;
        if (str == null || StringsKt.isBlank(str)) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Clipboard is empty — copy your token from the CNCVerse website first", (Integer) null, 2, (Object) null);
            return;
        }
        $pasteBtn.setEnabled(false);
        $pasteBtn.setText("Verifying…");
        BuildersKt.launch$default(this$0.scope, (CoroutineContext) null, (CoroutineStart) null, new SubscriptionManagerSettings$bindViews$1$1(this$0, token, $pasteBtn, $modeBadge, $statusText, $planText, $tokenField, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindViews$lambda$2(SubscriptionManagerSettings this$0, View it) {
        this$0.openBrowser(SIGNIN_URL);
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Sign in, copy your token, then come back and tap Paste & Verify", (Integer) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindViews$lambda$3(SubscriptionManagerSettings this$0, TextView $modeBadge, TextView $statusText, TextView $planText, TextView $tokenField, View it) {
        this$0.prefs.edit().remove(SubscriptionManagerPlugin.KEY_LICENSE_TOKEN).remove(SubscriptionManagerPlugin.KEY_PLAN).remove(SubscriptionManagerPlugin.KEY_EXPIRES_AT).remove(SubscriptionManagerPlugin.KEY_EMAIL).putString(SubscriptionManagerPlugin.KEY_MODE, "ads").apply();
        this$0.refreshStatus($modeBadge, $statusText, $planText, $tokenField);
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Account removed — switched to Ads mode", (Integer) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void refreshStatus(TextView modeBadge, TextView statusText, TextView planText, TextView tokenField) {
        String expiry;
        String str;
        String string = this.prefs.getString(SubscriptionManagerPlugin.KEY_MODE, "ads");
        String mode = string != null ? string : "ads";
        String token = this.prefs.getString(SubscriptionManagerPlugin.KEY_LICENSE_TOKEN, null);
        String plan = this.prefs.getString(SubscriptionManagerPlugin.KEY_PLAN, null);
        long expiresAt = this.prefs.getLong(SubscriptionManagerPlugin.KEY_EXPIRES_AT, 0L);
        String email = this.prefs.getString(SubscriptionManagerPlugin.KEY_EMAIL, null);
        if (Intrinsics.areEqual(mode, "subscription") && token != null) {
            long j = 1000;
            long nowSeconds = System.currentTimeMillis() / j;
            boolean isExpired = expiresAt > 0 && nowSeconds >= expiresAt;
            if (isExpired) {
                if (modeBadge != null) {
                    modeBadge.setText("❌ Subscription Expired");
                }
                if (modeBadge != null) {
                    modeBadge.setBackgroundResource(R.color.holo_red_dark);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
                String expiry2 = sdf.format(new Date(expiresAt * j));
                if (statusText != null) {
                    statusText.setText(email != null ? "Signed in as " + email : "Account linked");
                }
                if (planText != null) {
                    planText.setText(capitalise(plan == null ? "Active" : plan) + " Plan · Expired on " + expiry2);
                }
            } else {
                if (modeBadge != null) {
                    modeBadge.setText("✅ Subscription Mode");
                }
                if (modeBadge != null) {
                    modeBadge.setBackgroundResource(R.color.holo_green_dark);
                }
                if (expiresAt > 0) {
                    SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
                    expiry = sdf2.format(new Date(expiresAt * j));
                } else {
                    expiry = "Unknown";
                }
                if (statusText != null) {
                    statusText.setText(email != null ? "Signed in as " + email : "Account linked");
                }
                if (planText != null) {
                    planText.setText(capitalise(plan == null ? "Active" : plan) + " Plan · Expires " + expiry);
                }
            }
            if (tokenField != null) {
                if (token.length() > 8) {
                    str = "••••••••" + StringsKt.takeLast(token, 8);
                } else {
                    str = token;
                }
                tokenField.setText(str);
                return;
            }
            return;
        }
        if (modeBadge != null) {
            modeBadge.setText("📺 Ads Mode");
        }
        if (modeBadge != null) {
            modeBadge.setBackgroundResource(R.color.holo_orange_dark);
        }
        if (statusText != null) {
            statusText.setText("No subscription linked");
        }
        if (planText != null) {
            planText.setText("Subscribe to remove ads — from ₹30/month");
        }
        if (tokenField != null) {
            tokenField.setText("No token");
        }
    }

    private final String capitalise(String str) {
        if (!(str.length() > 0)) {
            return str;
        }
        char it = str.charAt(0);
        char upperCase = Character.toUpperCase(it);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return upperCase + strSubstring;
    }

    private final String getClipboardText() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence text;
        String string;
        Object systemService = requireContext().getSystemService("clipboard");
        ClipboardManager cm = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (cm == null || (primaryClip = cm.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null || (string = text.toString()) == null) {
            return null;
        }
        return StringsKt.trim(string).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openBrowser(String url) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (Exception e) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Could not open browser", (Integer) null, 2, (Object) null);
        }
    }

    /* JADX INFO: compiled from: SubscriptionManagerSettings.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/cncverse/SubscriptionManagerSettings$VerifyResult;", "", "valid", "", SubscriptionManagerPlugin.KEY_PLAN, "", "expiresAt", "", SubscriptionManagerPlugin.KEY_EMAIL, "errorMsg", "<init>", "(ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getValid", "()Z", "getPlan", "()Ljava/lang/String;", "getExpiresAt", "()J", "getEmail", "getErrorMsg", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "SubscriptionManager_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VerifyResult {

        @Nullable
        private final String email;

        @Nullable
        private final String errorMsg;
        private final long expiresAt;

        @Nullable
        private final String plan;
        private final boolean valid;

        public static /* synthetic */ VerifyResult copy$default(VerifyResult verifyResult, boolean z, String str, long j, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = verifyResult.valid;
            }
            if ((i & 2) != 0) {
                str = verifyResult.plan;
            }
            if ((i & 4) != 0) {
                j = verifyResult.expiresAt;
            }
            if ((i & 8) != 0) {
                str2 = verifyResult.email;
            }
            if ((i & 16) != 0) {
                str3 = verifyResult.errorMsg;
            }
            long j2 = j;
            return verifyResult.copy(z, str, j2, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getValid() {
            return this.valid;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPlan() {
            return this.plan;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getExpiresAt() {
            return this.expiresAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @NotNull
        public final VerifyResult copy(boolean valid, @Nullable String plan, long expiresAt, @Nullable String email, @Nullable String errorMsg) {
            return new VerifyResult(valid, plan, expiresAt, email, errorMsg);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyResult)) {
                return false;
            }
            VerifyResult verifyResult = (VerifyResult) other;
            return this.valid == verifyResult.valid && Intrinsics.areEqual(this.plan, verifyResult.plan) && this.expiresAt == verifyResult.expiresAt && Intrinsics.areEqual(this.email, verifyResult.email) && Intrinsics.areEqual(this.errorMsg, verifyResult.errorMsg);
        }

        public int hashCode() {
            return (((((((C0000xe65377f5.m0m(this.valid) * 31) + (this.plan == null ? 0 : this.plan.hashCode())) * 31) + C0001xe65377f6.m1m(this.expiresAt)) * 31) + (this.email == null ? 0 : this.email.hashCode())) * 31) + (this.errorMsg != null ? this.errorMsg.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "VerifyResult(valid=" + this.valid + ", plan=" + this.plan + ", expiresAt=" + this.expiresAt + ", email=" + this.email + ", errorMsg=" + this.errorMsg + ')';
        }

        public VerifyResult(boolean valid, @Nullable String plan, long expiresAt, @Nullable String email, @Nullable String errorMsg) {
            this.valid = valid;
            this.plan = plan;
            this.expiresAt = expiresAt;
            this.email = email;
            this.errorMsg = errorMsg;
        }

        public final boolean getValid() {
            return this.valid;
        }

        @Nullable
        public final String getPlan() {
            return this.plan;
        }

        public final long getExpiresAt() {
            return this.expiresAt;
        }

        @Nullable
        public final String getEmail() {
            return this.email;
        }

        @Nullable
        public final String getErrorMsg() {
            return this.errorMsg;
        }
    }

    /* JADX INFO: renamed from: com.cncverse.SubscriptionManagerSettings$verifyToken$2 */
    /* JADX INFO: compiled from: SubscriptionManagerSettings.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/cncverse/SubscriptionManagerSettings$VerifyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SubscriptionManagerSettings$verifyToken$2", f = "SubscriptionManagerSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nSubscriptionManagerSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionManagerSettings.kt\ncom/cncverse/SubscriptionManagerSettings$verifyToken$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,285:1\n1#2:286\n*E\n"})
    static final class C00032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyResult>, Object> {
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(String str, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$token = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00032(this.$token, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super VerifyResult> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00e5  */
        public final Object invokeSuspend(Object $result) {
            String text;
            String responseBody;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        URL url = new URL("https://cncverse-subscription-api.cncverse.workers.dev/license/verify");
                        URLConnection uRLConnectionOpenConnection = url.openConnection();
                        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        HttpURLConnection conn = (HttpURLConnection) uRLConnectionOpenConnection;
                        conn.setRequestMethod("POST");
                        conn.setRequestProperty("Content-Type", "application/json");
                        conn.setRequestProperty("Authorization", "Bearer " + this.$token);
                        conn.setDoOutput(true);
                        conn.setConnectTimeout(10000);
                        conn.setReadTimeout(10000);
                        String body = "{\"license_token\":\"" + this.$token + "\"}";
                        OutputStream it = conn.getOutputStream();
                        try {
                            byte[] bytes = body.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            it.write(bytes);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(it, (Throwable) null);
                            int responseCode = conn.getResponseCode();
                            try {
                                Reader inputStreamReader = new InputStreamReader(conn.getInputStream(), Charsets.UTF_8);
                                responseBody = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
                                break;
                            } catch (Exception e) {
                                InputStream errorStream = conn.getErrorStream();
                                if (errorStream != null) {
                                    Reader inputStreamReader2 = new InputStreamReader(errorStream, Charsets.UTF_8);
                                    text = TextStreamsKt.readText(inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192));
                                    if (text == null) {
                                        text = "";
                                    }
                                } else {
                                    text = "";
                                }
                                responseBody = text;
                            }
                            JSONObject json = new JSONObject(responseBody);
                            if (responseCode == 200 && json.optBoolean("valid", false)) {
                                String it2 = json.optString(SubscriptionManagerPlugin.KEY_PLAN);
                                String str = !StringsKt.isBlank(it2) ? it2 : null;
                                long jOptLong = json.optLong(SubscriptionManagerPlugin.KEY_EXPIRES_AT, 0L);
                                String it3 = json.optString(SubscriptionManagerPlugin.KEY_EMAIL);
                                return new VerifyResult(true, str, jOptLong, !StringsKt.isBlank(it3) ? it3 : null, null);
                            }
                            String it4 = json.optString("error");
                            String str2 = StringsKt.isBlank(it4) ? null : it4;
                            if (str2 == null) {
                                str2 = "Invalid or expired token";
                            }
                            String errMsg = str2;
                            return new VerifyResult(false, null, 0L, null, errMsg);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(it, th);
                                throw th2;
                            }
                        }
                    } catch (Exception e2) {
                        return new VerifyResult(false, null, 0L, null, "Network error: " + e2.getMessage());
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object verifyToken(String token, Continuation<? super VerifyResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00032(token, null), continuation);
    }
}
