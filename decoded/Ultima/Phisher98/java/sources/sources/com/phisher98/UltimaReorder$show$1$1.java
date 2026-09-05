package com.phisher98;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Reorder.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaReorder$show$1$1", f = "Reorder.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, nl = {80}, s = {}, v = 2)
final class UltimaReorder$show$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UltimaReorder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaReorder$show$1$1(UltimaReorder ultimaReorder, Continuation<? super UltimaReorder$show$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ultimaReorder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaReorder$show$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaReorder$show$1$1$1 */
    /* JADX INFO: compiled from: Reorder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaReorder$show$1$1$1", f = "Reorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ UltimaReorder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00201(UltimaReorder ultimaReorder, Continuation<? super C00201> continuation) {
            super(2, continuation);
            this.this$0 = ultimaReorder;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00201(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.this$0.sm.setCurrentExtensions(this.this$0.extensions);
                    this.this$0.getPlugin().reload();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        BottomSheetDialog bottomSheetDialog = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C00201(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved. Please restart the app to apply changes.", (Integer) null, 2, (Object) null);
        BottomSheetDialog bottomSheetDialog2 = this.this$0.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.dismiss();
        return Unit.INSTANCE;
    }
}
