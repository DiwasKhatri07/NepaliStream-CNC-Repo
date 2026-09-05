package com.Anichi;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: Anichi.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/Anichi/MetaAnimeData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Anichi.Anichi$load$2$metadataDeferred$1", f = "Anichi.kt", i = {0}, l = {252}, m = "invokeSuspend", n = {"malId"}, nl = {251}, s = {"I$0"}, v = 2)
final class Anichi$load$2$metadataDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MetaAnimeData>, Object> {
    final /* synthetic */ AnichiParser.AniMedia $trackers;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Anichi$load$2$metadataDeferred$1(AnichiParser.AniMedia aniMedia, Continuation<? super Anichi$load$2$metadataDeferred$1> continuation) {
        super(2, continuation);
        this.$trackers = aniMedia;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Anichi$load$2$metadataDeferred$1(this.$trackers, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MetaAnimeData> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Integer idMal;
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AnichiParser.AniMedia aniMedia = this.$trackers;
                if (aniMedia == null || (idMal = aniMedia.getIdMal()) == null) {
                    return null;
                }
                int malId = idMal.intValue();
                this.I$0 = malId;
                this.label = 1;
                obj = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + malId, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int i = this.I$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return AnichiUtilsKt.parseAnimeData(((NiceResponse) obj).getText());
    }
}
