package com.phisher98;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ShowBox.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/ShowBox/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.ShowBox", f = "ShowBox.kt", i = {0, 0, 0, 0}, l = {668}, m = "load$fetchCinemeta", n = {"this$0", "type", "imdbId", "it"}, nl = {669}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
final class ShowBox$load$fetchCinemeta$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    ShowBox$load$fetchCinemeta$1(Continuation<? super ShowBox$load$fetchCinemeta$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ShowBox.load$fetchCinemeta(null, null, null, (Continuation) this);
    }
}
