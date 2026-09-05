package com.phisher98;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StremioX.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioX$Stream$runCallback$sourceTrackers$2", f = "StremioX.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class StremioX$Stream$runCallback$sourceTrackers$2 extends SuspendLambda implements Function2<String, Continuation<? super String>, Object> {
    /* synthetic */ Object L$0;
    int label;

    StremioX$Stream$runCallback$sourceTrackers$2(Continuation<? super StremioX$Stream$runCallback$sourceTrackers$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioX$Stream$runCallback$sourceTrackers$2 = new StremioX$Stream$runCallback$sourceTrackers$2(continuation);
        stremioX$Stream$runCallback$sourceTrackers$2.L$0 = obj;
        return stremioX$Stream$runCallback$sourceTrackers$2;
    }

    public final Object invoke(String str, Continuation<? super String> continuation) {
        return create(str, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String it = (String) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return StringsKt.removePrefix(it, "tracker:");
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
