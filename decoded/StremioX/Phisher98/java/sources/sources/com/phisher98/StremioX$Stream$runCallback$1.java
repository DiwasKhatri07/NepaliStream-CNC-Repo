package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioX.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioX$Stream", f = "StremioX.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {396, 407, 418, 421, 424, 432, 437}, m = "runCallback", n = {"subtitleCallback", "callback", "subtitleCallback", "callback", "subtitleCallback", "callback", "subtitleCallback", "callback", "subtitleCallback", "callback", "subtitleCallback", "callback", "resp", "otherTrackers", "subtitleCallback", "callback", "resp", "otherTrackers", "sourceTrackers", "magnet"}, nl = {395, 417, 420, 423, 425, 433, 436}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
final class StremioX$Stream$runCallback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StremioX.Stream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioX$Stream$runCallback$1(StremioX.Stream stream, Continuation<? super StremioX$Stream$runCallback$1> continuation) {
        super(continuation);
        this.this$0 = stream;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runCallback(null, null, (Continuation) this);
    }
}
