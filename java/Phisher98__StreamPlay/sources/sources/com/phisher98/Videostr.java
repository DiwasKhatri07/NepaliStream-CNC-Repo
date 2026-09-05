package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/phisher98/Videostr;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "VideostrResponse", "VideostrSource", "Track", "Megakey", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Videostr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n1#2:4004\n2068#3,2:4005\n2068#3,2:4007\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Videostr\n*L\n2243#1:4005,2\n2245#1:4007,2\n*E\n"})
public final class Videostr extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Videostr";

    @NotNull
    private final String mainUrl = "https://videostr.net";

    /* JADX INFO: renamed from: com.phisher98.Videostr$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Videostr", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {2202, 2211, 2222, 2233, 2238, 2247}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "headers", "id", "url", "referer", "subtitleCallback", "callback", "headers", "id", "html", "nonce", "apiUrl", "url", "referer", "subtitleCallback", "callback", "headers", "id", "html", "nonce", "apiUrl", "response", "encodedSource", "url", "referer", "subtitleCallback", "callback", "headers", "id", "html", "nonce", "apiUrl", "response", "encodedSource", "key", "decodeUrl", "fullUrl", "url", "referer", "subtitleCallback", "callback", "headers", "id", "html", "nonce", "apiUrl", "response", "encodedSource", "m3u8", "url", "referer", "subtitleCallback", "callback", "headers", "id", "html", "nonce", "apiUrl", "response", "encodedSource", "m3u8", "$this$forEach$iv", "element$iv", "it"}, nl = {2204, 2212, 2223, 2234, 2243, 2249}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15"}, v = 2)
    static final class C03091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
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

        C03091(Continuation<? super C03091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Videostr.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0694  */
    /* JADX WARN: Code duplicated, block: B:68:0x06ae  */
    /* JADX WARN: Code duplicated, block: B:74:0x0734 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x0735  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:89:0x06c1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0735 -> B:76:0x074b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r38, @org.jetbrains.annotations.Nullable java.lang.String r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r41, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r42) {
        /*
            Method dump skipped, instruction units count: 1952
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Videostr.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/phisher98/Videostr$VideostrResponse;", "", "sources", "", "Lcom/phisher98/Videostr$VideostrSource;", "tracks", "Lcom/phisher98/Videostr$Track;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getTracks", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class VideostrResponse {

        @NotNull
        private final List<VideostrSource> sources;

        @NotNull
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideostrResponse copy$default(VideostrResponse videostrResponse, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = videostrResponse.sources;
            }
            if ((i & 2) != 0) {
                list2 = videostrResponse.tracks;
            }
            return videostrResponse.copy(list, list2);
        }

        @NotNull
        public final List<VideostrSource> component1() {
            return this.sources;
        }

        @NotNull
        public final List<Track> component2() {
            return this.tracks;
        }

        @NotNull
        public final VideostrResponse copy(@NotNull List<VideostrSource> sources, @NotNull List<Track> tracks) {
            return new VideostrResponse(sources, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideostrResponse)) {
                return false;
            }
            VideostrResponse videostrResponse = (VideostrResponse) other;
            return Intrinsics.areEqual(this.sources, videostrResponse.sources) && Intrinsics.areEqual(this.tracks, videostrResponse.tracks);
        }

        public int hashCode() {
            return (this.sources.hashCode() * 31) + this.tracks.hashCode();
        }

        @NotNull
        public String toString() {
            return "VideostrResponse(sources=" + this.sources + ", tracks=" + this.tracks + ')';
        }

        public VideostrResponse(@NotNull List<VideostrSource> list, @NotNull List<Track> list2) {
            this.sources = list;
            this.tracks = list2;
        }

        @NotNull
        public final List<VideostrSource> getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Track> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/phisher98/Videostr$VideostrSource;", "", "file", "", "<init>", "(Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class VideostrSource {

        @NotNull
        private final String file;

        public static /* synthetic */ VideostrSource copy$default(VideostrSource videostrSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videostrSource.file;
            }
            return videostrSource.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final VideostrSource copy(@NotNull String file) {
            return new VideostrSource(file);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VideostrSource) && Intrinsics.areEqual(this.file, ((VideostrSource) other).file);
        }

        public int hashCode() {
            return this.file.hashCode();
        }

        @NotNull
        public String toString() {
            return "VideostrSource(file=" + this.file + ')';
        }

        public VideostrSource(@NotNull String file) {
            this.file = file;
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/Videostr$Track;", "", "file", "", "label", "kind", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Track {

        @NotNull
        private final String file;

        @NotNull
        private final String kind;

        @NotNull
        private final String label;

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                str3 = track.kind;
            }
            return track.copy(str, str2, str3);
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

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        @NotNull
        public final Track copy(@NotNull String file, @NotNull String label, @NotNull String kind) {
            return new Track(file, label, kind);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind);
        }

        public int hashCode() {
            return (((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + this.kind.hashCode();
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Track(@NotNull String file, @NotNull String label, @NotNull String kind) {
            this.file = file;
            this.label = label;
            this.kind = kind;
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final String getKind() {
            return this.kind;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/phisher98/Videostr$Megakey;", "", "vidstr", "", "<init>", "(Ljava/lang/String;)V", "getVidstr", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Megakey {

        @NotNull
        private final String vidstr;

        public static /* synthetic */ Megakey copy$default(Megakey megakey, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = megakey.vidstr;
            }
            return megakey.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVidstr() {
            return this.vidstr;
        }

        @NotNull
        public final Megakey copy(@NotNull String vidstr) {
            return new Megakey(vidstr);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Megakey) && Intrinsics.areEqual(this.vidstr, ((Megakey) other).vidstr);
        }

        public int hashCode() {
            return this.vidstr.hashCode();
        }

        @NotNull
        public String toString() {
            return "Megakey(vidstr=" + this.vidstr + ')';
        }

        public Megakey(@NotNull String vidstr) {
            this.vidstr = vidstr;
        }

        @NotNull
        public final String getVidstr() {
            return this.vidstr;
        }
    }
}
