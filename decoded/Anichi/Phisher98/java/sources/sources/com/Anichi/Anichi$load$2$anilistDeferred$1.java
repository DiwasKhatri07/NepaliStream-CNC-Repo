package com.Anichi;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Anichi.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/Anichi/AnilistAPIResponse$anilistMedia;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Anichi.Anichi$load$2$anilistDeferred$1", f = "Anichi.kt", i = {0}, l = {245}, m = "invokeSuspend", n = {"aniId"}, nl = {247}, s = {"I$0"}, v = 2)
final class Anichi$load$2$anilistDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnilistAPIResponse.anilistMedia>, Object> {
    final /* synthetic */ AnichiParser.AniMedia $trackers;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Anichi$load$2$anilistDeferred$1(AnichiParser.AniMedia aniMedia, Continuation<? super Anichi$load$2$anilistDeferred$1> continuation) {
        super(2, continuation);
        this.$trackers = aniMedia;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Anichi$load$2$anilistDeferred$1(this.$trackers, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnilistAPIResponse.anilistMedia> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) throws Exception {
        Object objAnilistAPICall;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AnichiParser.AniMedia aniMedia = this.$trackers;
                if (aniMedia == null) {
                    return null;
                }
                int aniId = aniMedia.getId();
                this.I$0 = aniId;
                this.label = 1;
                objAnilistAPICall = AnichiUtilsKt.anilistAPICall("query { Media(id: " + aniId + ", type: ANIME) { id title { romaji english } startDate { year } genres description averageScore status bannerImage coverImage { extraLarge large medium } episodes format nextAiringEpisode { episode } airingSchedule { nodes { episode } } recommendations { edges { node { id mediaRecommendation { id title { romaji english } coverImage { extraLarge large medium } } } } } } }", this);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = this.I$0;
                ResultKt.throwOnFailure($result);
                objAnilistAPICall = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((AnilistAPIResponse) objAnilistAPICall).getData().getMedia();
    }
}
