package com.Hdmovie2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Hdmovie2.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hdmovie2/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Hdmovie2.Hdmovie2", f = "Hdmovie2.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {300}, m = "loadLinks$fetchSource", n = {"ajaxUrl", "commonHeaders", "$data", "this$0", "post", "nume", "type"}, nl = {310}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
final class Hdmovie2$loadLinks$fetchSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    Hdmovie2$loadLinks$fetchSource$1(Continuation<? super Hdmovie2$loadLinks$fetchSource$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Hdmovie2.loadLinks$fetchSource(null, null, null, null, null, null, null, (Continuation) this);
    }
}
