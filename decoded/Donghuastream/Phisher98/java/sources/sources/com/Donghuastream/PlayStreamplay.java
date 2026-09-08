package com.Donghuastream;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Donghuastream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/Donghuastream/PlayStreamplay;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "Query", "Source", "Track", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/Donghuastream/PlayStreamplay\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,253:1\n73#2,5:254\n1#3:259\n2068#4,2:260\n2068#4,2:262\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/Donghuastream/PlayStreamplay\n*L\n189#1:254,5\n206#1:260,2\n209#1:262,2\n*E\n"})
public class PlayStreamplay extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private String name = "All sub player";

    @NotNull
    private String mainUrl = "https://play.streamplay.co.in";

    /* JADX INFO: renamed from: com.Donghuastream.PlayStreamplay$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.PlayStreamplay", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {182, 189, 206, 211}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "doc", "packedScript", "evalRegex", "packedCode", "unpackedJs", "token", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "doc", "packedScript", "evalRegex", "packedCode", "unpackedJs", "token", "apiUrl", "response", "m3u8Url", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "doc", "packedScript", "evalRegex", "packedCode", "unpackedJs", "token", "apiUrl", "response", "m3u8Url", "$this$forEach$iv", "element$iv", "subtitle"}, nl = {183, 254, 260, 210}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayStreamplay.getUrl$suspendImpl(PlayStreamplay.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:86:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0566 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x0567  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0567 -> B:90:0x0576). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.Donghuastream.PlayStreamplay r35, java.lang.String r36, java.lang.String r37, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 1478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Donghuastream.PlayStreamplay.getUrl$suspendImpl(com.Donghuastream.PlayStreamplay, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0003J}\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u00061"}, d2 = {"Lcom/Donghuastream/PlayStreamplay$Response;", "", "query", "Lcom/Donghuastream/PlayStreamplay$Query;", "status", "", "message", "embed_url", "download_url", "title", "poster", "filmstrip", "sources", "", "Lcom/Donghuastream/PlayStreamplay$Source;", "tracks", "Lcom/Donghuastream/PlayStreamplay$Track;", "<init>", "(Lcom/Donghuastream/PlayStreamplay$Query;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getQuery", "()Lcom/Donghuastream/PlayStreamplay$Query;", "getStatus", "()Ljava/lang/String;", "getMessage", "getEmbed_url", "getDownload_url", "getTitle", "getPoster", "getFilmstrip", "getSources", "()Ljava/util/List;", "getTracks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Response {

        @Nullable
        private final String download_url;

        @Nullable
        private final String embed_url;

        @NotNull
        private final String filmstrip;

        @NotNull
        private final String message;

        @NotNull
        private final String poster;

        @NotNull
        private final Query query;

        @NotNull
        private final List<Source> sources;

        @NotNull
        private final String status;

        @NotNull
        private final String title;

        @NotNull
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, Query query, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                query = response.query;
            }
            if ((i & 2) != 0) {
                str = response.status;
            }
            if ((i & 4) != 0) {
                str2 = response.message;
            }
            if ((i & 8) != 0) {
                str3 = response.embed_url;
            }
            if ((i & 16) != 0) {
                str4 = response.download_url;
            }
            if ((i & 32) != 0) {
                str5 = response.title;
            }
            if ((i & 64) != 0) {
                str6 = response.poster;
            }
            if ((i & 128) != 0) {
                str7 = response.filmstrip;
            }
            if ((i & 256) != 0) {
                list = response.sources;
            }
            if ((i & 512) != 0) {
                list2 = response.tracks;
            }
            List list3 = list;
            List list4 = list2;
            String str8 = str6;
            String str9 = str7;
            String str10 = str4;
            String str11 = str5;
            return response.copy(query, str, str2, str3, str10, str11, str8, str9, list3, list4);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Query getQuery() {
            return this.query;
        }

        @NotNull
        public final List<Track> component10() {
            return this.tracks;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDownload_url() {
            return this.download_url;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getFilmstrip() {
            return this.filmstrip;
        }

        @NotNull
        public final List<Source> component9() {
            return this.sources;
        }

        @NotNull
        public final Response copy(@NotNull Query query, @NotNull String status, @NotNull String message, @Nullable String embed_url, @Nullable String download_url, @NotNull String title, @NotNull String poster, @NotNull String filmstrip, @NotNull List<Source> sources, @NotNull List<Track> tracks) {
            return new Response(query, status, message, embed_url, download_url, title, poster, filmstrip, sources, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return Intrinsics.areEqual(this.query, response.query) && Intrinsics.areEqual(this.status, response.status) && Intrinsics.areEqual(this.message, response.message) && Intrinsics.areEqual(this.embed_url, response.embed_url) && Intrinsics.areEqual(this.download_url, response.download_url) && Intrinsics.areEqual(this.title, response.title) && Intrinsics.areEqual(this.poster, response.poster) && Intrinsics.areEqual(this.filmstrip, response.filmstrip) && Intrinsics.areEqual(this.sources, response.sources) && Intrinsics.areEqual(this.tracks, response.tracks);
        }

        public int hashCode() {
            return (((((((((((((((((this.query.hashCode() * 31) + this.status.hashCode()) * 31) + this.message.hashCode()) * 31) + (this.embed_url == null ? 0 : this.embed_url.hashCode())) * 31) + (this.download_url != null ? this.download_url.hashCode() : 0)) * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.filmstrip.hashCode()) * 31) + this.sources.hashCode()) * 31) + this.tracks.hashCode();
        }

        @NotNull
        public String toString() {
            return "Response(query=" + this.query + ", status=" + this.status + ", message=" + this.message + ", embed_url=" + this.embed_url + ", download_url=" + this.download_url + ", title=" + this.title + ", poster=" + this.poster + ", filmstrip=" + this.filmstrip + ", sources=" + this.sources + ", tracks=" + this.tracks + ')';
        }

        public Response(@NotNull Query query, @NotNull String status, @NotNull String message, @Nullable String embed_url, @Nullable String download_url, @NotNull String title, @NotNull String poster, @NotNull String filmstrip, @NotNull List<Source> list, @NotNull List<Track> list2) {
            this.query = query;
            this.status = status;
            this.message = message;
            this.embed_url = embed_url;
            this.download_url = download_url;
            this.title = title;
            this.poster = poster;
            this.filmstrip = filmstrip;
            this.sources = list;
            this.tracks = list2;
        }

        public /* synthetic */ Response(Query query, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(query, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, str5, str6, str7, list, list2);
        }

        @NotNull
        public final Query getQuery() {
            return this.query;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @Nullable
        public final String getDownload_url() {
            return this.download_url;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getFilmstrip() {
            return this.filmstrip;
        }

        @NotNull
        public final List<Source> getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Track> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Donghuastream/PlayStreamplay$Query;", "", "source", "", "id", "download", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getId", "getDownload", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Query {

        @NotNull
        private final String download;

        @NotNull
        private final String id;

        @NotNull
        private final String source;

        public static /* synthetic */ Query copy$default(Query query, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = query.source;
            }
            if ((i & 2) != 0) {
                str2 = query.id;
            }
            if ((i & 4) != 0) {
                str3 = query.download;
            }
            return query.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDownload() {
            return this.download;
        }

        @NotNull
        public final Query copy(@NotNull String source, @NotNull String id, @NotNull String download) {
            return new Query(source, id, download);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Query)) {
                return false;
            }
            Query query = (Query) other;
            return Intrinsics.areEqual(this.source, query.source) && Intrinsics.areEqual(this.id, query.id) && Intrinsics.areEqual(this.download, query.download);
        }

        public int hashCode() {
            return (((this.source.hashCode() * 31) + this.id.hashCode()) * 31) + this.download.hashCode();
        }

        @NotNull
        public String toString() {
            return "Query(source=" + this.source + ", id=" + this.id + ", download=" + this.download + ')';
        }

        public Query(@NotNull String source, @NotNull String id, @NotNull String download) {
            this.source = source;
            this.id = id;
            this.download = download;
        }

        @NotNull
        public final String getSource() {
            return this.source;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getDownload() {
            return this.download;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/Donghuastream/PlayStreamplay$Source;", "", "file", "", "type", "label", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getFile", "()Ljava/lang/String;", "getType", "getLabel", "getDefault", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Source {
        private final boolean default;

        @NotNull
        private final String file;

        @NotNull
        private final String label;

        @NotNull
        private final String type;

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, String str3, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.file;
            }
            if ((i & 2) != 0) {
                str2 = source.type;
            }
            if ((i & 4) != 0) {
                str3 = source.label;
            }
            if ((i & 8) != 0) {
                z = source.default;
            }
            return source.copy(str, str2, str3, z);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getDefault() {
            return this.default;
        }

        @NotNull
        public final Source copy(@NotNull String file, @NotNull String type, @NotNull String label, boolean z) {
            return new Source(file, type, label, z);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics.areEqual(this.file, source.file) && Intrinsics.areEqual(this.type, source.type) && Intrinsics.areEqual(this.label, source.label) && this.default == source.default;
        }

        public int hashCode() {
            return (((((this.file.hashCode() * 31) + this.type.hashCode()) * 31) + this.label.hashCode()) * 31) + PlayStreamplay$Source$$ExternalSyntheticBackport0.m0m(this.default);
        }

        @NotNull
        public String toString() {
            return "Source(file=" + this.file + ", type=" + this.type + ", label=" + this.label + ", default=" + this.default + ')';
        }

        public Source(@NotNull String file, @NotNull String type, @NotNull String label, boolean z) {
            this.file = file;
            this.type = type;
            this.label = label;
            this.default = z;
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public final boolean getDefault() {
            return this.default;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/Donghuastream/PlayStreamplay$Track;", "", "file", "", "label", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/Donghuastream/PlayStreamplay$Track;", "equals", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Track {

        @Nullable
        private final Boolean default;

        @NotNull
        private final String file;

        @NotNull
        private final String label;

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                bool = track.default;
            }
            return track.copy(str, str2, bool);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getDefault() {
            return this.default;
        }

        @NotNull
        public final Track copy(@NotNull String file, @NotNull String label, @Nullable Boolean bool) {
            return new Track(file, label, bool);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.default, track.default);
        }

        public int hashCode() {
            return (((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + (this.default == null ? 0 : this.default.hashCode());
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", default=" + this.default + ')';
        }

        public Track(@NotNull String file, @NotNull String label, @Nullable Boolean bool) {
            this.file = file;
            this.label = label;
            this.default = bool;
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final Boolean getDefault() {
            return this.default;
        }
    }
}
