package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioC$Stream", f = "StremioC.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5}, l = {622, 635, 644, 647, 650, 663}, m = "runCallback", n = {"subtitleCallback", "callback", "subtitleCallback", "callback", "$this$forEach$iv", "element$iv", "sub", "subtitleCallback", "callback", "subtitleCallback", "callback", "subtitleCallback", "callback", "subtitleCallback", "callback", "resp", "otherTrackers", "sourceTrackers", "magnet"}, nl = {621, 634, 646, 649, 651, 662}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
final class StremioC$Stream$runCallback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StremioC.Stream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioC$Stream$runCallback$1(StremioC.Stream stream, Continuation<? super StremioC$Stream$runCallback$1> continuation) {
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
