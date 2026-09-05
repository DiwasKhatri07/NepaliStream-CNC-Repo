package com.cncverse;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BilibiliProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/BilibiliProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.BilibiliProvider$tryExtractFromPage$3$1", f = "BilibiliProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class BilibiliProvider$tryExtractFromPage$3$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ Qualities $quality;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BilibiliProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BilibiliProvider$tryExtractFromPage$3$1(Qualities qualities, BilibiliProvider bilibiliProvider, String str, Continuation<? super BilibiliProvider$tryExtractFromPage$3$1> continuation) {
        super(2, continuation);
        this.$quality = qualities;
        this.this$0 = bilibiliProvider;
        this.$pageUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> bilibiliProvider$tryExtractFromPage$3$1 = new BilibiliProvider$tryExtractFromPage$3$1(this.$quality, this.this$0, this.$pageUrl, continuation);
        bilibiliProvider$tryExtractFromPage$3$1.L$0 = obj;
        return bilibiliProvider$tryExtractFromPage$3$1;
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
                $this$newExtractorLink.setQuality(this.$quality.ordinal());
                $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"), TuplesKt.to("Referer", this.$pageUrl)}));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
