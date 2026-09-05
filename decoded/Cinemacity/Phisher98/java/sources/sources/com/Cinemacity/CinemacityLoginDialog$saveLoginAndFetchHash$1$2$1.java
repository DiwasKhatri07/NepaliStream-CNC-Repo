package com.Cinemacity;

import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CinemacityLoginDialog.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinemacity/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1", f = "CinemacityLoginDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CinemacityLoginDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(CinemacityLoginDialog cinemacityLoginDialog, Continuation<? super CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = cinemacityLoginDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.updateStatus("✅ Logged in! (hash fetch failed – will retry on search)");
                WebView webView = this.this$0.webView;
                if (webView != null) {
                    final CinemacityLoginDialog cinemacityLoginDialog = this.this$0;
                    Boxing.boxBoolean(webView.postDelayed(new Runnable() { // from class: com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1.invokeSuspend$lambda$0(cinemacityLoginDialog);
                        }
                    }, 1500L));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final void invokeSuspend$lambda$0(CinemacityLoginDialog this$0) {
        if (this$0.isAdded()) {
            Function1 function1 = this$0.onFinished;
            if (function1 != null) {
                function1.invoke(true);
            }
            this$0.dismissAllowingStateLoss();
        }
    }
}
