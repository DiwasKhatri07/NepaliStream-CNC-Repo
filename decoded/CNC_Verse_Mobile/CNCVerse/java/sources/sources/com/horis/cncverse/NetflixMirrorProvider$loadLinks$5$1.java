package com.horis.cncverse;

import com.lagradost.cloudstream3.SubtitleFile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NetflixMirrorProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse_Mobile/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SubtitleFile;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.horis.cncverse.NetflixMirrorProvider$loadLinks$5$1", f = "NetflixMirrorProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class NetflixMirrorProvider$loadLinks$5$1 extends SuspendLambda implements Function2<SubtitleFile, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetflixMirrorProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetflixMirrorProvider$loadLinks$5$1(NetflixMirrorProvider netflixMirrorProvider, Continuation<? super NetflixMirrorProvider$loadLinks$5$1> continuation) {
        super(2, continuation);
        this.this$0 = netflixMirrorProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netflixMirrorProvider$loadLinks$5$1 = new NetflixMirrorProvider$loadLinks$5$1(this.this$0, continuation);
        netflixMirrorProvider$loadLinks$5$1.L$0 = obj;
        return netflixMirrorProvider$loadLinks$5$1;
    }

    public final Object invoke(SubtitleFile subtitleFile, Continuation<? super Unit> continuation) {
        return create(subtitleFile, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SubtitleFile $this$newSubtitleFile = (SubtitleFile) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newSubtitleFile.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl() + '/')));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
