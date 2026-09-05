package com.phisher98;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.lagradost.cloudstream3.MainActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaPlugin$pullChangedCategories$2$1", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class UltimaPlugin$pullChangedCategories$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UltimaPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaPlugin$pullChangedCategories$2$1(UltimaPlugin ultimaPlugin, Continuation<? super UltimaPlugin$pullChangedCategories$2$1> continuation) {
        super(2, continuation);
        this.this$0 = ultimaPlugin;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaPlugin$pullChangedCategories$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    AppCompatActivity act = this.this$0.getActivity();
                    if (act != null && act.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                        MainActivity.Companion.getBookmarksUpdatedEvent().invoke(Boxing.boxBoolean(true));
                    }
                    break;
                } catch (Throwable th) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
