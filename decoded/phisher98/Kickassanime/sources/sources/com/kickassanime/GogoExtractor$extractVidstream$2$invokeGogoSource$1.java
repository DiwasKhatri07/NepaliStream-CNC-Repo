package com.kickassanime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GogoExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kickassanime/classes.dex */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.kickassanime.GogoExtractor$extractVidstream$2", f = "GogoExtractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {126, 134}, m = "invokeSuspend$invokeGogoSource", n = {"$mainApiName", "mainUrl", "source", "sourceCallback", "$mainApiName", "mainUrl", "source", "sourceCallback"}, nl = {131, 133}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
final class GogoExtractor$extractVidstream$2$invokeGogoSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    GogoExtractor$extractVidstream$2$invokeGogoSource$1(Continuation<? super GogoExtractor$extractVidstream$2$invokeGogoSource$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GogoExtractor.C00002.invokeSuspend$invokeGogoSource(null, null, null, null, (Continuation) this);
    }
}
