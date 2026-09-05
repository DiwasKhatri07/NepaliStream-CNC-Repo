package com.phisher98;

import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: TorraStream.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "season", "Lcom/phisher98/Seasons;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.TorraStream$load$episodes$1", f = "TorraStream.kt", i = {0, 0}, l = {208}, m = "invokeSuspend", n = {"season", "mediaType"}, nl = {209}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$episodes$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,549:1\n73#2,5:550\n1739#3:555\n1814#3,3:556\n*S KotlinDebug\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$episodes$1\n*L\n209#1:550,5\n209#1:555\n209#1:556,3\n*E\n"})
final class TorraStream$load$episodes$1 extends SuspendLambda implements Function2<Seasons, Continuation<? super List<? extends Episode>>, Object> {
    final /* synthetic */ Data $data;
    final /* synthetic */ boolean $isAnime;
    final /* synthetic */ MediaDetail $res;
    final /* synthetic */ Integer $year;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TorraStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TorraStream$load$episodes$1(Data data, TorraStream torraStream, MediaDetail mediaDetail, Integer num, boolean z, Continuation<? super TorraStream$load$episodes$1> continuation) {
        super(2, continuation);
        this.$data = data;
        this.this$0 = torraStream;
        this.$res = mediaDetail;
        this.$year = num;
        this.$isAnime = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> torraStream$load$episodes$1 = new TorraStream$load$episodes$1(this.$data, this.this$0, this.$res, this.$year, this.$isAnime, continuation);
        torraStream$load$episodes$1.L$0 = obj;
        return torraStream$load$episodes$1;
    }

    public final Object invoke(Seasons seasons, Continuation<? super List<Episode>> continuation) {
        return create(seasons, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object safe;
        ArrayList arrayList;
        Iterable episodes;
        Seasons season = (Seasons) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String mediaType = this.$data.getType();
                if (mediaType == null) {
                    mediaType = "tv";
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(season);
                this.L$1 = SpillingKt.nullOutSpilledVariable(mediaType);
                this.label = 1;
                obj = Requests.get$default(MainActivityKt.getApp(), "https://api.themoviedb.org/3/" + mediaType + '/' + this.$data.getId() + "/season/" + season.getSeasonNumber() + "?api_key=1865f43a0549ca50d341dd9ab8b29f49", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(MediaDetailEpisodes.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        MediaDetailEpisodes mediaDetailEpisodes = (MediaDetailEpisodes) safe;
        if (mediaDetailEpisodes == null || (episodes = mediaDetailEpisodes.getEpisodes()) == null) {
            arrayList = null;
        } else {
            Iterable $this$map$iv = episodes;
            final MainAPI mainAPI = this.this$0;
            MediaDetail mediaDetail = this.$res;
            Integer num = this.$year;
            boolean z = this.$isAnime;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                final Episodes eps = (Episodes) item$iv$iv;
                MainAPI mainAPI2 = mainAPI;
                AppUtils appUtils = AppUtils.INSTANCE;
                Collection destination$iv$iv2 = destination$iv$iv;
                String title = mediaDetail.getTitle();
                ExternalIds external_ids = mediaDetail.getExternal_ids();
                destination$iv$iv2.add(MainAPIKt.newEpisode(mainAPI2, appUtils.toJson(new LoadData(title, num, z, external_ids != null ? external_ids.getImdb_id() : null, eps.getSeasonNumber(), eps.getEpisodeNumber())), new Function1() { // from class: com.phisher98.TorraStream$load$episodes$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        return TorraStream$load$episodes$1.invokeSuspend$lambda$0$0(eps, mainAPI, (Episode) obj2);
                    }
                }));
                destination$iv$iv = destination$iv$iv2;
                $this$map$iv = $this$map$iv;
                season = season;
            }
            arrayList = (List) destination$iv$iv;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(Episodes $eps, TorraStream this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($eps.getName() + (this$0.isUpcoming($eps.getAirDate()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason($eps.getSeasonNumber());
        $this$newEpisode.setEpisode($eps.getEpisodeNumber());
        $this$newEpisode.setPosterUrl(this$0.getImageUrl($eps.getStillPath()));
        $this$newEpisode.setScore(Score.Companion.from10($eps.getVoteAverage()));
        $this$newEpisode.setDescription($eps.getOverview());
        MainAPIKt.addDate$default($this$newEpisode, $eps.getAirDate(), (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }
}
