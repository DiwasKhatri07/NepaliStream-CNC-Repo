package com.cncverse;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SubscriptionManagerSettings.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SubscriptionManager/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.SubscriptionManagerSettings$bindViews$1$1", f = "SubscriptionManagerSettings.kt", i = {1}, l = {108, 109}, m = "invokeSuspend", n = {"result"}, nl = {109, 129}, s = {"L$0"}, v = 2)
final class SubscriptionManagerSettings$bindViews$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextView $modeBadge;
    final /* synthetic */ Button $pasteBtn;
    final /* synthetic */ TextView $planText;
    final /* synthetic */ TextView $statusText;
    final /* synthetic */ String $token;
    final /* synthetic */ TextView $tokenField;
    Object L$0;
    int label;
    final /* synthetic */ SubscriptionManagerSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscriptionManagerSettings$bindViews$1$1(SubscriptionManagerSettings subscriptionManagerSettings, String str, Button button, TextView textView, TextView textView2, TextView textView3, TextView textView4, Continuation<? super SubscriptionManagerSettings$bindViews$1$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionManagerSettings;
        this.$token = str;
        this.$pasteBtn = button;
        this.$modeBadge = textView;
        this.$statusText = textView2;
        this.$planText = textView3;
        this.$tokenField = textView4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionManagerSettings$bindViews$1$1(this.this$0, this.$token, this.$pasteBtn, this.$modeBadge, this.$statusText, this.$planText, this.$tokenField, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0063 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0064  */
    public final Object invokeSuspend(Object $result) {
        Object objVerifyToken;
        SubscriptionManagerSettings.VerifyResult result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objVerifyToken = this.this$0.verifyToken(this.$token, (Continuation) this);
                if (objVerifyToken == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (SubscriptionManagerSettings.VerifyResult) objVerifyToken;
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00021(this.$pasteBtn, result, this.this$0, this.$token, this.$modeBadge, this.$statusText, this.$planText, this.$tokenField, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                objVerifyToken = $result;
                result = (SubscriptionManagerSettings.VerifyResult) objVerifyToken;
                this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00021(this.$pasteBtn, result, this.this$0, this.$token, this.$modeBadge, this.$statusText, this.$planText, this.$tokenField, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.SubscriptionManagerSettings$bindViews$1$1$1 */
    /* JADX INFO: compiled from: SubscriptionManagerSettings.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.SubscriptionManagerSettings$bindViews$1$1$1", f = "SubscriptionManagerSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $modeBadge;
        final /* synthetic */ Button $pasteBtn;
        final /* synthetic */ TextView $planText;
        final /* synthetic */ SubscriptionManagerSettings.VerifyResult $result;
        final /* synthetic */ TextView $statusText;
        final /* synthetic */ String $token;
        final /* synthetic */ TextView $tokenField;
        int label;
        final /* synthetic */ SubscriptionManagerSettings this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00021(Button button, SubscriptionManagerSettings.VerifyResult verifyResult, SubscriptionManagerSettings subscriptionManagerSettings, String str, TextView textView, TextView textView2, TextView textView3, TextView textView4, Continuation<? super C00021> continuation) {
            super(2, continuation);
            this.$pasteBtn = button;
            this.$result = verifyResult;
            this.this$0 = subscriptionManagerSettings;
            this.$token = str;
            this.$modeBadge = textView;
            this.$statusText = textView2;
            this.$planText = textView3;
            this.$tokenField = textView4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00021(this.$pasteBtn, this.$result, this.this$0, this.$token, this.$modeBadge, this.$statusText, this.$planText, this.$tokenField, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String msg;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.$pasteBtn.setEnabled(true);
                    this.$pasteBtn.setText("Paste & Verify");
                    if (this.$result != null && this.$result.getValid()) {
                        SharedPreferences.Editor editorPutString = this.this$0.prefs.edit().putString(SubscriptionManagerPlugin.KEY_LICENSE_TOKEN, this.$token).putString(SubscriptionManagerPlugin.KEY_MODE, "subscription");
                        String plan = this.$result.getPlan();
                        if (plan == null) {
                            plan = "";
                        }
                        SharedPreferences.Editor editorPutLong = editorPutString.putString(SubscriptionManagerPlugin.KEY_PLAN, plan).putLong(SubscriptionManagerPlugin.KEY_EXPIRES_AT, this.$result.getExpiresAt());
                        String email = this.$result.getEmail();
                        editorPutLong.putString(SubscriptionManagerPlugin.KEY_EMAIL, email != null ? email : "").apply();
                        this.this$0.refreshStatus(this.$modeBadge, this.$statusText, this.$planText, this.$tokenField);
                        CommonActivity.showToast$default(CommonActivity.INSTANCE, "✅ Subscription active! Ads removed.", (Integer) null, 2, (Object) null);
                    } else {
                        SubscriptionManagerSettings.VerifyResult verifyResult = this.$result;
                        if (verifyResult == null || (msg = verifyResult.getErrorMsg()) == null) {
                            msg = "Token verification failed";
                        }
                        CommonActivity.showToast$default(CommonActivity.INSTANCE, "❌ " + msg, (Integer) null, 2, (Object) null);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
