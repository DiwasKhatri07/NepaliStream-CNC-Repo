package com.Desicinemas;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tvlogy.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Desicinemas/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Desicinemas.Tvlogyflow", f = "Tvlogy.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {74, 90}, m = "getUrl$process", n = {"$callback", "this$0", "doc", "direct", "$callback", "this$0", "doc", "direct", "juicy"}, nl = {73, 89}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
final class Tvlogyflow$getUrl$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    Tvlogyflow$getUrl$process$1(Continuation<? super Tvlogyflow$getUrl$process$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Tvlogyflow.getUrl$process(null, null, null, (Continuation) this);
    }
}
