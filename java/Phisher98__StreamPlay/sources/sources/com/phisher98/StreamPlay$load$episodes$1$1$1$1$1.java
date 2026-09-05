package com.phisher98;

import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$load$episodes$1$1$1$1$1", f = "StreamPlay.kt", i = {}, l = {465}, m = "invokeSuspend", n = {}, nl = {466}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$episodes$1$1$1$1$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,929:1\n73#2,5:930\n1739#3:935\n1814#3,2:936\n296#3,2:938\n1816#3:940\n*S KotlinDebug\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$episodes$1$1$1$1$1\n*L\n466#1:930,5\n468#1:935\n468#1:936,2\n487#1:938,2\n468#1:940\n*E\n"})
final class StreamPlay$load$episodes$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Episode>>, Object> {
    final /* synthetic */ StreamPlay.Data $data;
    final /* synthetic */ String $enTitle;
    final /* synthetic */ boolean $isAnime;
    final /* synthetic */ boolean $isAsian;
    final /* synthetic */ boolean $isBollywood;
    final /* synthetic */ boolean $isCartoon;
    final /* synthetic */ Integer $lastSeason;
    final /* synthetic */ String $orgTitle;
    final /* synthetic */ Ref.ObjectRef<StreamPlay.MediaDetail> $res;
    final /* synthetic */ StreamPlay.Seasons $season;
    final /* synthetic */ String $tmdbAPI;
    final /* synthetic */ Integer $year;
    int label;
    final /* synthetic */ StreamPlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$load$episodes$1$1$1$1$1(String str, StreamPlay.Data data, StreamPlay.Seasons seasons, StreamPlay streamPlay, Ref.ObjectRef<StreamPlay.MediaDetail> objectRef, String str2, String str3, boolean z, Integer num, Integer num2, boolean z2, boolean z3, boolean z4, Continuation<? super StreamPlay$load$episodes$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$tmdbAPI = str;
        this.$data = data;
        this.$season = seasons;
        this.this$0 = streamPlay;
        this.$res = objectRef;
        this.$enTitle = str2;
        this.$orgTitle = str3;
        this.$isAnime = z;
        this.$year = num;
        this.$lastSeason = num2;
        this.$isAsian = z2;
        this.$isBollywood = z3;
        this.$isCartoon = z4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlay$load$episodes$1$1$1$1$1(this.$tmdbAPI, this.$data, this.$season, this.this$0, this.$res, this.$enTitle, this.$orgTitle, this.$isAnime, this.$year, this.$lastSeason, this.$isAsian, this.$isBollywood, this.$isCartoon, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Episode>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:60:0x01e2 A[LOOP:1: B:43:0x01a2->B:60:0x01e2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:70:0x0210  */
    /* JADX WARN: Code duplicated, block: B:81:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x01f0 A[SYNTHETIC] */
    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object safe;
        Iterable episodes;
        AppUtils appUtils;
        String releaseDate;
        Iterable results;
        Object element$iv;
        boolean z;
        List listSplit$default;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                obj = Requests.get$default(MainActivityKt.getApp(), this.$tmdbAPI + '/' + this.$data.getType() + '/' + this.$data.getId() + "/season/" + this.$season.getSeasonNumber() + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&language=" + this.this$0.getLangCode(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
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
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(StreamPlay.MediaDetailEpisodes.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        StreamPlay.MediaDetailEpisodes mediaDetailEpisodes = (StreamPlay.MediaDetailEpisodes) safe;
        if (mediaDetailEpisodes == null || (episodes = mediaDetailEpisodes.getEpisodes()) == null) {
            Object obj2 = null;
            return obj2;
        }
        Iterable $this$map$iv = episodes;
        final StreamPlay streamPlay = this.this$0;
        StreamPlay.Data data = this.$data;
        Ref.ObjectRef<StreamPlay.MediaDetail> objectRef = this.$res;
        String str2 = this.$enTitle;
        StreamPlay.Seasons seasons = this.$season;
        String str3 = this.$orgTitle;
        boolean z2 = this.$isAnime;
        Integer num = this.$year;
        Integer num2 = this.$lastSeason;
        boolean z3 = this.$isAsian;
        boolean z4 = this.$isBollywood;
        boolean z5 = this.$isCartoon;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            boolean z6 = z5;
            final StreamPlay.Episodes eps = (StreamPlay.Episodes) item$iv$iv;
            StreamPlay streamPlay2 = streamPlay;
            AppUtils appUtils2 = AppUtils.INSTANCE;
            StreamPlay.Seasons seasons2 = seasons;
            Integer id = data.getId();
            Iterable $this$map$iv2 = $this$map$iv;
            StreamPlay.ExternalIds external_ids = ((StreamPlay.MediaDetail) objectRef.element).getExternal_ids();
            String imdb_id = external_ids != null ? external_ids.getImdb_id() : null;
            StreamPlay.ExternalIds external_ids2 = ((StreamPlay.MediaDetail) objectRef.element).getExternal_ids();
            Integer tvdb_id = external_ids2 != null ? external_ids2.getTvdb_id() : null;
            Integer num3 = num;
            String type = data.getType();
            Integer num4 = num2;
            Integer seasonNumber = eps.getSeasonNumber();
            boolean z7 = z3;
            Integer episodeNumber = eps.getEpisodeNumber();
            boolean z8 = z4;
            Integer id2 = eps.getId();
            String airDate = seasons2.getAirDate();
            Integer intOrNull = (airDate == null || (listSplit$default = StringsKt.split$default(airDate, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str = (String) CollectionsKt.first(listSplit$default)) == null) ? null : StringsKt.toIntOrNull(str);
            String name = eps.getName();
            Integer num5 = tvdb_id;
            StreamPlay.ResultsAltTitles alternative_titles = ((StreamPlay.MediaDetail) objectRef.element).getAlternative_titles();
            if (alternative_titles == null || (results = alternative_titles.getResults()) == null) {
                appUtils = appUtils2;
            } else {
                Iterable $this$firstOrNull$iv = results;
                Iterator it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        StreamPlay.AltTitles it2 = (StreamPlay.AltTitles) element$iv;
                        Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                        if (Intrinsics.areEqual(it2.getIso_3166_1(), "JP")) {
                            String type2 = it2.getType();
                            if (type2 != null) {
                                appUtils = appUtils2;
                                boolean z9 = StringsKt.equals(type2, "romaji", true);
                                z = z9;
                                if (!z) {
                                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                    appUtils2 = appUtils;
                                }
                            } else {
                                appUtils = appUtils2;
                            }
                            if (z9) {
                            }
                            if (!z) {
                                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                appUtils2 = appUtils;
                            }
                        } else {
                            appUtils = appUtils2;
                        }
                        if (!z) {
                            $this$firstOrNull$iv = $this$firstOrNull$iv2;
                            appUtils2 = appUtils;
                        }
                    } else {
                        appUtils = appUtils2;
                        element$iv = null;
                    }
                }
                StreamPlay.AltTitles altTitles = (StreamPlay.AltTitles) element$iv;
                String title = altTitles != null ? altTitles.getTitle() : null;
                String airDate2 = seasons2.getAirDate();
                releaseDate = ((StreamPlay.MediaDetail) objectRef.element).getReleaseDate();
                if (releaseDate == null) {
                    releaseDate = ((StreamPlay.MediaDetail) objectRef.element).getFirstAirDate();
                }
                String str4 = str2;
                String str5 = str3;
                Integer num6 = intOrNull;
                boolean z10 = z2;
                Episode $this$invokeSuspend_u24lambda_u240_u242 = MainAPIKt.newEpisode(streamPlay2, appUtils.toJson(new StreamPlay.LinkData(id, imdb_id, num5, type, seasonNumber, episodeNumber, id2, null, null, str4, num6, str5, z10, num3, num4, name, title, airDate2, releaseDate, z7, z8, z6, ((StreamPlay.MediaDetail) objectRef.element).getTitle(), ((StreamPlay.MediaDetail) objectRef.element).getName(), false, null, 50332032, null)), new Function1() { // from class: com.phisher98.StreamPlay$load$episodes$1$1$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj3) {
                        return StreamPlay$load$episodes$1$1$1$1$1.invokeSuspend$lambda$0$1(eps, streamPlay, (Episode) obj3);
                    }
                });
                MainAPIKt.addDate$default($this$invokeSuspend_u24lambda_u240_u242, eps.getAirDate(), (String) null, 2, (Object) null);
                destination$iv$iv.add($this$invokeSuspend_u24lambda_u240_u242);
                str2 = str4;
                str3 = str5;
                z2 = z10;
                num = num3;
                num2 = num4;
                z3 = z7;
                z4 = z8;
                z5 = z6;
                seasons = seasons2;
                $this$map$iv = $this$map$iv2;
                data = data;
            }
            String airDate3 = seasons2.getAirDate();
            releaseDate = ((StreamPlay.MediaDetail) objectRef.element).getReleaseDate();
            if (releaseDate == null) {
                releaseDate = ((StreamPlay.MediaDetail) objectRef.element).getFirstAirDate();
            }
            String str6 = str2;
            String str7 = str3;
            Integer num7 = intOrNull;
            boolean z11 = z2;
            Episode $this$invokeSuspend_u24lambda_u240_u243 = MainAPIKt.newEpisode(streamPlay2, appUtils.toJson(new StreamPlay.LinkData(id, imdb_id, num5, type, seasonNumber, episodeNumber, id2, null, null, str6, num7, str7, z11, num3, num4, name, title, airDate3, releaseDate, z7, z8, z6, ((StreamPlay.MediaDetail) objectRef.element).getTitle(), ((StreamPlay.MediaDetail) objectRef.element).getName(), false, null, 50332032, null)), new Function1() { // from class: com.phisher98.StreamPlay$load$episodes$1$1$1$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3) {
                    return StreamPlay$load$episodes$1$1$1$1$1.invokeSuspend$lambda$0$1(eps, streamPlay, (Episode) obj3);
                }
            });
            MainAPIKt.addDate$default($this$invokeSuspend_u24lambda_u240_u243, eps.getAirDate(), (String) null, 2, (Object) null);
            destination$iv$iv.add($this$invokeSuspend_u24lambda_u240_u243);
            str2 = str6;
            str3 = str7;
            z2 = z11;
            num = num3;
            num2 = num4;
            z3 = z7;
            z4 = z8;
            z5 = z6;
            seasons = seasons2;
            $this$map$iv = $this$map$iv2;
            data = data;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$1(StreamPlay.Episodes $eps, StreamPlay this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($eps.getName() + (StreamPlayUtilsKt.isUpcoming($eps.getAirDate()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason($eps.getSeasonNumber());
        $this$newEpisode.setEpisode($eps.getEpisodeNumber());
        $this$newEpisode.setPosterUrl(this$0.getImageUrl($eps.getStillPath()));
        $this$newEpisode.setScore(Score.Companion.from10($eps.getVoteAverage()));
        $this$newEpisode.setDescription($eps.getOverview());
        $this$newEpisode.setRunTime($eps.getRunTime());
        return Unit.INSTANCE;
    }
}
