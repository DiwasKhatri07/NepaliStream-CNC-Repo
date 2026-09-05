package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStream.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/SuperStream/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.SuperStream$Companion", f = "SuperStream.kt", i = {}, l = {114}, m = "fetchProxyList", n = {}, nl = {115}, s = {}, v = 2)
final class SuperStream$Companion$fetchProxyList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SuperStream.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuperStream$Companion$fetchProxyList$1(SuperStream.Companion companion, Continuation<? super SuperStream$Companion$fetchProxyList$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchProxyList((Continuation) this);
    }
}
