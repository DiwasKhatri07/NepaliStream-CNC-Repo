package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StremioX.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioX$Stream$runCallback$2", f = "StremioX.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class StremioX$Stream$runCallback$2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StremioX.Stream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioX$Stream$runCallback$2(StremioX.Stream stream, Continuation<? super StremioX$Stream$runCallback$2> continuation) {
        super(2, continuation);
        this.this$0 = stream;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioX$Stream$runCallback$2 = new StremioX$Stream$runCallback$2(this.this$0, continuation);
        stremioX$Stream$runCallback$2.L$0 = obj;
        return stremioX$Stream$runCallback$2;
    }

    public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
        return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Map<String, String> headers;
        StremioX.ProxyHeaders proxyHeaders;
        ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newExtractorLink.setQuality(UtilsKt.getQuality(CollectionsKt.listOf(new String[]{this.this$0.getDescription(), this.this$0.getTitle(), $this$newExtractorLink.getName()})));
                StremioX.BehaviorHints behaviorHints = this.this$0.getBehaviorHints();
                if (behaviorHints == null || (proxyHeaders = behaviorHints.getProxyHeaders()) == null || (headers = proxyHeaders.getRequest()) == null) {
                    StremioX.BehaviorHints behaviorHints2 = this.this$0.getBehaviorHints();
                    headers = behaviorHints2 != null ? behaviorHints2.getHeaders() : null;
                    if (headers == null) {
                        headers = MapsKt.emptyMap();
                    }
                }
                $this$newExtractorLink.setHeaders(headers);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
