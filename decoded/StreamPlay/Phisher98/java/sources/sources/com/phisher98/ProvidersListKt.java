package com.phisher98;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProvidersList.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\"!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"getDubStatus", "", "res", "Lcom/phisher98/StreamPlay$LinkData;", "getAnimeIds", "Lcom/phisher98/StreamPlayExtractor$AnimeResolvedIds;", "(Lcom/phisher98/StreamPlay$LinkData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "providers", "", "Lcom/phisher98/Provider;", "getProviders", "()Ljava/util/List;", "providers$delegate", "Lkotlin/Lazy;", "buildProviders", "StreamPlay"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProvidersList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProvidersList.kt\ncom/phisher98/ProvidersListKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n777#2:354\n873#2,2:355\n*S KotlinDebug\n*F\n+ 1 ProvidersList.kt\ncom/phisher98/ProvidersListKt\n*L\n95#1:354\n95#1:355,2\n*E\n"})
public final class ProvidersListKt {

    @NotNull
    private static final Lazy providers$delegate = LazyKt.lazy(new Function0() { // from class: com.phisher98.ProvidersListKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            return CollectionsKt.listOf(new Provider[]{new Provider("uhdmovies", "UHD Movies", new ProvidersListKt$providers$2$1(null)), new Provider("hianime", "HiAnime", new ProvidersListKt$providers$2$2(null)), new Provider("animetosho", "AnimeTosho", new ProvidersListKt$providers$2$3(null)), new Provider("ReAnime", "ReAnime", new ProvidersListKt$providers$2$4(null)), new Provider("Animex", "Animex", new ProvidersListKt$providers$2$5(null)), new Provider("kickass", "KickAssAnime", new ProvidersListKt$providers$2$6(null)), new Provider("animepahe", "AnimePahe", new ProvidersListKt$providers$2$7(null)), new Provider("anichi", "Anichi / AllAnime", new ProvidersListKt$providers$2$8(null)), new Provider("anikage", "Anikage", new ProvidersListKt$providers$2$9(null)), new Provider("anikoto", "Anikoto", new ProvidersListKt$providers$2$10(null)), new Provider("anineko", "AniNeko", new ProvidersListKt$providers$2$11(null)), new Provider("tokyoinsider", "Tokyo Insider", new ProvidersListKt$providers$2$12(null)), new Provider("anizone", "AniZone", new ProvidersListKt$providers$2$13(null)), new Provider("topmovies", "Top Movies", new ProvidersListKt$providers$2$14(null)), new Provider("moviesmod", "MoviesMod", new ProvidersListKt$providers$2$15(null)), new Provider("bollyflix", "Bollyflix", new ProvidersListKt$providers$2$16(null)), new Provider("watchsomuch", "WatchSoMuch", new ProvidersListKt$providers$2$17(null)), new Provider("ninetv", "NineTV", new ProvidersListKt$providers$2$18(null)), new Provider("allmovieland", "AllMovieland", new ProvidersListKt$providers$2$19(null)), new Provider("vegamovies", "VegaMovies", new ProvidersListKt$providers$2$20(null)), new Provider("Rogmovies", "RogMovies", new ProvidersListKt$providers$2$21(null)), new Provider("multimovies", "MultiMovies", new ProvidersListKt$providers$2$22(null)), new Provider("zshow", "ZShow", new ProvidersListKt$providers$2$23(null)), new Provider("nepu", "Nepu", new ProvidersListKt$providers$2$24(null)), new Provider("moviesdrive", "MoviesDrive", new ProvidersListKt$providers$2$25(null)), new Provider("superstream", "SuperStream", new ProvidersListKt$providers$2$26(null)), new Provider("vidsrcxyz", "VidSrcXyz", new ProvidersListKt$providers$2$27(null)), new Provider("vidzeeapi", "Vidzee API", new ProvidersListKt$providers$2$28(null)), new Provider("4khdhub", "4kHdhub (Multi)", new ProvidersListKt$providers$2$29(null)), new Provider("hdhub4u", "Hdhub4u (Multi)", new ProvidersListKt$providers$2$30(null)), new Provider("hdmovie2", "Hdmovie2", new ProvidersListKt$providers$2$31(null)), new Provider("rivestream", "RiveStream", new ProvidersListKt$providers$2$32(null)), new Provider("moviebox", "MovieBox (Multi)", new ProvidersListKt$providers$2$33(null)), new Provider("vidrock", "Vidrock", new ProvidersListKt$providers$2$34(null)), new Provider("vidlink", "Vidlink", new ProvidersListKt$providers$2$35(null)), new Provider("kisskh", "KissKH (Asian Drama)", new ProvidersListKt$providers$2$36(null)), new Provider("dahmermovies", "DahmerMovies", new ProvidersListKt$providers$2$37(null)), new Provider("vidfast", "VidFast", new ProvidersListKt$providers$2$38(null)), new Provider("VidEasy", "VidEasy", new ProvidersListKt$providers$2$39(null)), new Provider("moviesapi", "MoviesApi Club", new ProvidersListKt$providers$2$40(null)), new Provider("CinemaCity", "CinemaCity", new ProvidersListKt$providers$2$41(null)), new Provider("HexaSU", "HexaSU", new ProvidersListKt$providers$2$42(null)), new Provider("Hindmoviez", "HindMoviez", new ProvidersListKt$providers$2$43(null)), new Provider("Movies4u", "Movies4u", new ProvidersListKt$providers$2$44(null)), new Provider("M4uhd", "M4uhd", new ProvidersListKt$providers$2$45(null)), new Provider("MappleTV", "MappleTV", new ProvidersListKt$providers$2$46(null)), new Provider("WyZIESUB", "WyZIESUB (Subtitles)", new ProvidersListKt$providers$2$47(null)), new Provider("SubtitleAPI", "SubtitleAPI (Subtitles)", new ProvidersListKt$providers$2$48(null)), new Provider("CineVood", "CineVood (Movies Only)", new ProvidersListKt$providers$2$49(null)), new Provider("Filmyfiy", "Filmyfiy (Movies Only)", new ProvidersListKt$providers$2$50(null)), new Provider("2Embed", "2Embed", new ProvidersListKt$providers$2$51(null)), new Provider("DooFlix", "DooFlix", new ProvidersListKt$providers$2$52(null)), new Provider("Xpass", "Xpass", new ProvidersListKt$providers$2$53(null)), new Provider("vaplayer", "Vaplayer", new ProvidersListKt$providers$2$54(null)), new Provider("Dudefilms", "Dudefilms", new ProvidersListKt$providers$2$55(null)), new Provider("Zinkmovies", "Zinkmovies", new ProvidersListKt$providers$2$56(null)), new Provider("Peachify", "Peachify", new ProvidersListKt$providers$2$57(null)), new Provider("goated", "Goated", new ProvidersListKt$providers$2$58(null))});
        }
    });

    /* JADX INFO: renamed from: com.phisher98.ProvidersListKt$getAnimeIds$1 */
    /* JADX INFO: compiled from: ProvidersList.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ProvidersListKt", f = "ProvidersList.kt", i = {0, 0, 0}, l = {105}, m = "getAnimeIds", n = {"res", "cacheKey", "cached"}, nl = {107}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00601(Continuation<? super C00601> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProvidersListKt.getAnimeIds(null, (Continuation) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDubStatus(StreamPlay.LinkData res) {
        if (Intrinsics.areEqual(res.isMovie(), true)) {
            return "Movie";
        }
        return res.isDub() ? "DUB" : "SUB";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object getAnimeIds(StreamPlay.LinkData res, Continuation<? super StreamPlayExtractor.AnimeResolvedIds> continuation) {
        C00601 c00601;
        Object objResolveAnimeIds;
        String cacheKey;
        ArrayList arrayList;
        Iterable iterableSplit$default;
        if (continuation instanceof C00601) {
            c00601 = (C00601) continuation;
            if ((c00601.label & Integer.MIN_VALUE) != 0) {
                c00601.label -= Integer.MIN_VALUE;
            } else {
                c00601 = new C00601(continuation);
            }
        } else {
            c00601 = new C00601(continuation);
        }
        C00601 c00602 = c00601;
        Object $result = c00602.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00602.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StringBuilder sbAppend = new StringBuilder().append(res.getTitle()).append('_');
                String date = res.getDate();
                if (date == null) {
                    date = res.getAiredDate();
                }
                StringBuilder sbAppend2 = sbAppend.append(date).append('_');
                Integer season = res.getSeason();
                String cacheKey2 = sbAppend2.append(season != null ? season.intValue() : 0).toString();
                StreamPlayCache.AnimeIdMapping cached = StreamPlayCache.INSTANCE.getCachedAnimeIds(cacheKey2);
                if (cached != null) {
                    String malId = cached.getMalId();
                    Integer intOrNull = malId != null ? StringsKt.toIntOrNull(malId) : null;
                    String anilistId = cached.getAnilistId();
                    Integer intOrNull2 = anilistId != null ? StringsKt.toIntOrNull(anilistId) : null;
                    String zoroId = cached.getZoroId();
                    if (zoroId == null || (iterableSplit$default = StringsKt.split$default(zoroId, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                        arrayList = null;
                    } else {
                        Iterable $this$filter$iv = iterableSplit$default;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            String it = (String) element$iv$iv;
                            if (!StringsKt.isBlank(it)) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        arrayList = (List) destination$iv$iv;
                    }
                    return new StreamPlayExtractor.AnimeResolvedIds(intOrNull, intOrNull2, 0, arrayList, null, null, null, null, cached.getAnimekaiId(), null);
                }
                StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                String title = res.getTitle();
                String date2 = res.getDate();
                String airedDate = res.getAiredDate();
                Integer season2 = res.getSeason();
                Integer episode = res.getEpisode();
                c00602.L$0 = SpillingKt.nullOutSpilledVariable(res);
                c00602.L$1 = cacheKey2;
                c00602.L$2 = SpillingKt.nullOutSpilledVariable(cached);
                c00602.label = 1;
                objResolveAnimeIds = streamPlayExtractor.resolveAnimeIds(title, date2, airedDate, season2, episode, c00602);
                if (objResolveAnimeIds == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cacheKey = cacheKey2;
                break;
                break;
            case 1:
                cacheKey = (String) c00602.L$1;
                ResultKt.throwOnFailure($result);
                objResolveAnimeIds = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        StreamPlayExtractor.AnimeResolvedIds ids = (StreamPlayExtractor.AnimeResolvedIds) objResolveAnimeIds;
        StreamPlayCache streamPlayCache = StreamPlayCache.INSTANCE;
        Integer malId2 = ids.getMalId();
        String strValueOf = malId2 != null ? String.valueOf(malId2.intValue()) : null;
        List<String> zoroIds = ids.getZoroIds();
        streamPlayCache.cacheAnimeIds(cacheKey, new StreamPlayCache.AnimeIdMapping(null, strValueOf, null, zoroIds != null ? CollectionsKt.joinToString$default(zoroIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : null, null, 0L, 48, null));
        return ids;
    }

    private static final List<Provider> getProviders() {
        return (List) providers$delegate.getValue();
    }

    @NotNull
    public static final List<Provider> buildProviders() {
        return getProviders();
    }
}
