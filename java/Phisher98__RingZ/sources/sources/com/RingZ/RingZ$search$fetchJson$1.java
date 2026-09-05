package com.RingZ;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RingZ.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/RingZ/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.RingZ.RingZ", f = "RingZ.kt", i = {0}, l = {283}, m = "search$fetchJson", n = {"url"}, nl = {-1}, s = {"L$0"}, v = 2)
final class RingZ$search$fetchJson$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    RingZ$search$fetchJson$1(Continuation<? super RingZ$search$fetchJson$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RingZ.search$fetchJson(null, (Continuation) this);
    }
}
