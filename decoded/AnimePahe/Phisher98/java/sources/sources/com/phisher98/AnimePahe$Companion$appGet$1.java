package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimePahe.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.AnimePahe$Companion", f = "AnimePahe.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {126, 548, 131, 136, 141}, m = "appGet", n = {"url", "customHeaders", "url", "customHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "customHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "customHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "recheck", "url", "customHeaders", "rawResponse", "recheckPassed"}, nl = {127, 549, 132, 138, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3"}, v = 2)
final class AnimePahe$Companion$appGet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnimePahe.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimePahe$Companion$appGet$1(AnimePahe.Companion companion, Continuation<? super AnimePahe$Companion$appGet$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.appGet(null, null, (Continuation) this);
    }
}
