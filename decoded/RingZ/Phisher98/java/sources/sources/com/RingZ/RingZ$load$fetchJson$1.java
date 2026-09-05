package com.RingZ;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RingZ.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/RingZ/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {0}, l = {367}, m = "load$fetchJson", n = {"fullUrl"}, nl = {-1}, s = {"L$0"}, v = 2)
final class RingZ$load$fetchJson$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    RingZ$load$fetchJson$1(Continuation<? super RingZ$load$fetchJson$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RingZ.load$fetchJson(null, (Continuation) this);
    }
}
