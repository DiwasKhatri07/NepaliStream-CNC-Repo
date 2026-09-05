package com.phisher98;

import android.widget.Button;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: XDMoviesSettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.XDMoviesSettingsFragment$onCreateView$2$1", f = "XDMoviesSettingsFragment.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, nl = {95}, s = {}, v = 2)
final class XDMoviesSettingsFragment$onCreateView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Button $bypassBtn;
    int label;
    final /* synthetic */ XDMoviesSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XDMoviesSettingsFragment$onCreateView$2$1(Button button, XDMoviesSettingsFragment xDMoviesSettingsFragment, Continuation<? super XDMoviesSettingsFragment$onCreateView$2$1> continuation) {
        super(2, continuation);
        this.$bypassBtn = button;
        this.this$0 = xDMoviesSettingsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XDMoviesSettingsFragment$onCreateView$2$1(this.$bypassBtn, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objWithContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new XDMoviesSettingsFragment$onCreateView$2$1$isValid$1(null), (Continuation) this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean isValid = ((Boolean) objWithContext).booleanValue();
        this.$bypassBtn.setEnabled(true);
        Button button = this.$bypassBtn;
        if (isValid) {
            button.setText("✅ CF Cookie still valid!");
            Toast.makeText(this.this$0.getContext(), "✅ Existing CF cookie is still accepted (200 OK)", 1).show();
        } else {
            button.setText("🛡️ Bypass Cloudflare");
            final Button button2 = this.$bypassBtn;
            CloudflareWebViewDialog dialog = new CloudflareWebViewDialog("https://top.xdmovies.wtf/series/agent-kim-reactivated-1080p-720p-english-korean-download-296206", new Function1() { // from class: com.phisher98.XDMoviesSettingsFragment$onCreateView$2$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return XDMoviesSettingsFragment$onCreateView$2$1.invokeSuspend$lambda$0(button2, ((Boolean) obj).booleanValue());
                }
            });
            dialog.show(this.this$0.getParentFragmentManager(), "xdmovies_cf_bypass");
        }
        return Unit.INSTANCE;
    }

    static final Unit invokeSuspend$lambda$0(Button $bypassBtn, boolean saved) {
        if (saved) {
            $bypassBtn.setText("✅ CF Cookies Saved – Refresh");
        }
        return Unit.INSTANCE;
    }
}
