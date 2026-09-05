package com.Fibwatch;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Fibwatch.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/Fibwatch/LoadItem;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Fibwatch.Fibwatch$loadLinks$currentUrls$1", f = "Fibwatch.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class Fibwatch$loadLinks$currentUrls$1 extends SuspendLambda implements Function2<LoadItem, Continuation<? super String>, Object> {
    /* synthetic */ Object L$0;
    int label;

    Fibwatch$loadLinks$currentUrls$1(Continuation<? super Fibwatch$loadLinks$currentUrls$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fibwatch$loadLinks$currentUrls$1 = new Fibwatch$loadLinks$currentUrls$1(continuation);
        fibwatch$loadLinks$currentUrls$1.L$0 = obj;
        return fibwatch$loadLinks$currentUrls$1;
    }

    public final Object invoke(LoadItem loadItem, Continuation<? super String> continuation) {
        return create(loadItem, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        LoadItem it = (LoadItem) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return StringsKt.trim(it.getUrl()).toString();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
