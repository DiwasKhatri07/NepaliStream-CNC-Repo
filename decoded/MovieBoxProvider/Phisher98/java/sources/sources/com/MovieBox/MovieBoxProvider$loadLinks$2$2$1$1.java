package com.MovieBox;

import com.lagradost.cloudstream3.utils.ExtractorLink;
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

/* JADX INFO: compiled from: MovieBoxProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBoxProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.MovieBox.MovieBoxProvider$loadLinks$2$2$1$1", f = "MovieBoxProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class MovieBoxProvider$loadLinks$2$2$1$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $quality;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MovieBoxProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieBoxProvider$loadLinks$2$2$1$1(MovieBoxProvider movieBoxProvider, int i, Continuation<? super MovieBoxProvider$loadLinks$2$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = movieBoxProvider;
        this.$quality = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> movieBoxProvider$loadLinks$2$2$1$1 = new MovieBoxProvider$loadLinks$2$2$1$1(this.this$0, this.$quality, continuation);
        movieBoxProvider$loadLinks$2$2$1$1.L$0 = obj;
        return movieBoxProvider$loadLinks$2$2$1$1;
    }

    public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
        return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl())));
                $this$newExtractorLink.setQuality(this.$quality);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
