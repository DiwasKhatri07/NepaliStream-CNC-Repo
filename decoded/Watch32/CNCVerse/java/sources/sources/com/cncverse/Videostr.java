package com.cncverse;

import com.fasterxml.jackson.annotation.JsonProperty;
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
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Watch32/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/cncverse/Videostr;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "VideostrResponse", "VideostrSource", "Track", "Megakey", "Watch32_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/cncverse/Videostr\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n63#2:133\n64#2,15:135\n63#2:152\n64#2,15:154\n1#3:134\n1#3:153\n50#4:150\n43#4:151\n50#4:169\n43#4:170\n1915#5,2:171\n1915#5,2:173\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/cncverse/Videostr\n*L\n44#1:133\n44#1:135,15\n55#1:152\n55#1:154,15\n44#1:134\n55#1:153\n44#1:150\n44#1:151\n55#1:169\n55#1:170\n89#1:171,2\n94#1:173,2\n*E\n"})
public final class Videostr extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Videostr";

    @NotNull
    private final String mainUrl = "https://videostr.net";

    /* JADX INFO: renamed from: com.cncverse.Videostr$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.Videostr", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {32, 43, 52, 76, 89, 97}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "headers", "id", "url", "referer", "subtitleCallback", "callback", "headers", "id", "responsenonce", "match1", "match2", "nonce", "apiUrl", "url", "referer", "subtitleCallback", "callback", "headers", "id", "responsenonce", "match1", "match2", "nonce", "apiUrl", "response", "url", "referer", "subtitleCallback", "callback", "headers", "id", "responsenonce", "match1", "match2", "nonce", "apiUrl", "response", "key", "encodedSource", "decodeUrl", "fullUrl", "url", "referer", "subtitleCallback", "callback", "headers", "id", "responsenonce", "match1", "match2", "nonce", "apiUrl", "response", "key", "encodedSource", "m3u8", "m3u8headers", "url", "referer", "subtitleCallback", "callback", "headers", "id", "responsenonce", "match1", "match2", "nonce", "apiUrl", "response", "key", "encodedSource", "m3u8", "m3u8headers", "$this$forEach$iv", "element$iv", "track", "$i$f$forEach", "$i$a$-forEach-Videostr$getUrl$2"}, nl = {33, 44, 54, 77, 171, 96}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "I$0", "I$1"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        int I$1;
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
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
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

    /* JADX WARN: Code duplicated, block: B:157:0x0910  */
    /* JADX WARN: Code duplicated, block: B:159:0x092b  */
    /* JADX WARN: Code duplicated, block: B:165:0x09d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:166:0x09d3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x0938 -> B:168:0x09fe). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:166:0x09d3 -> B:167:0x09eb). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r41, @org.jetbrains.annotations.Nullable java.lang.String r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r44, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r45) {
        /*
            Method dump skipped, instruction units count: 2838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.Videostr.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\nHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/cncverse/Videostr$VideostrResponse;", "", "sources", "", "Lcom/cncverse/Videostr$VideostrSource;", "tracks", "Lcom/cncverse/Videostr$Track;", "encrypted", "", "f", "", "server", "", "<init>", "(Ljava/util/List;Ljava/util/List;ZLjava/lang/String;J)V", "getSources", "()Ljava/util/List;", "getTracks", "getEncrypted", "()Z", "getF", "()Ljava/lang/String;", "getServer", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Watch32_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideostrResponse {
        private final boolean encrypted;

        @JsonProperty("_f")
        @NotNull
        private final String f;
        private final long server;

        @NotNull
        private final List<VideostrSource> sources;

        @NotNull
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideostrResponse copy$default(VideostrResponse videostrResponse, List list, List list2, boolean z, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                list = videostrResponse.sources;
            }
            if ((i & 2) != 0) {
                list2 = videostrResponse.tracks;
            }
            if ((i & 4) != 0) {
                z = videostrResponse.encrypted;
            }
            if ((i & 8) != 0) {
                str = videostrResponse.f;
            }
            if ((i & 16) != 0) {
                j = videostrResponse.server;
            }
            long j2 = j;
            return videostrResponse.copy(list, list2, z, str, j2);
        }

        @NotNull
        public final List<VideostrSource> component1() {
            return this.sources;
        }

        @NotNull
        public final List<Track> component2() {
            return this.tracks;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getEncrypted() {
            return this.encrypted;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getF() {
            return this.f;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getServer() {
            return this.server;
        }

        @NotNull
        public final VideostrResponse copy(@NotNull List<VideostrSource> sources, @NotNull List<Track> tracks, boolean encrypted, @JsonProperty("_f") @NotNull String f, long server) {
            return new VideostrResponse(sources, tracks, encrypted, f, server);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideostrResponse)) {
                return false;
            }
            VideostrResponse videostrResponse = (VideostrResponse) other;
            return Intrinsics.areEqual(this.sources, videostrResponse.sources) && Intrinsics.areEqual(this.tracks, videostrResponse.tracks) && this.encrypted == videostrResponse.encrypted && Intrinsics.areEqual(this.f, videostrResponse.f) && this.server == videostrResponse.server;
        }

        public int hashCode() {
            return (((((((this.sources.hashCode() * 31) + this.tracks.hashCode()) * 31) + Videostr$VideostrResponse$$ExternalSyntheticBackport0.m0m(this.encrypted)) * 31) + this.f.hashCode()) * 31) + Videostr$VideostrResponse$$ExternalSyntheticBackport1.m1m(this.server);
        }

        @NotNull
        public String toString() {
            return "VideostrResponse(sources=" + this.sources + ", tracks=" + this.tracks + ", encrypted=" + this.encrypted + ", f=" + this.f + ", server=" + this.server + ')';
        }

        public VideostrResponse(@NotNull List<VideostrSource> list, @NotNull List<Track> list2, boolean encrypted, @JsonProperty("_f") @NotNull String f, long server) {
            this.sources = list;
            this.tracks = list2;
            this.encrypted = encrypted;
            this.f = f;
            this.server = server;
        }

        @NotNull
        public final List<VideostrSource> getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Track> getTracks() {
            return this.tracks;
        }

        public final boolean getEncrypted() {
            return this.encrypted;
        }

        @NotNull
        public final String getF() {
            return this.f;
        }

        public final long getServer() {
            return this.server;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/Videostr$VideostrSource;", "", "file", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Watch32_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideostrSource {

        @NotNull
        private final String file;

        @NotNull
        private final String type;

        public static /* synthetic */ VideostrSource copy$default(VideostrSource videostrSource, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videostrSource.file;
            }
            if ((i & 2) != 0) {
                str2 = videostrSource.type;
            }
            return videostrSource.copy(str, str2);
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
        public final VideostrSource copy(@NotNull String file, @NotNull String type) {
            return new VideostrSource(file, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideostrSource)) {
                return false;
            }
            VideostrSource videostrSource = (VideostrSource) other;
            return Intrinsics.areEqual(this.file, videostrSource.file) && Intrinsics.areEqual(this.type, videostrSource.type);
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "VideostrSource(file=" + this.file + ", type=" + this.type + ')';
        }

        public VideostrSource(@NotNull String file, @NotNull String type) {
            this.file = file;
            this.type = type;
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JB\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/cncverse/Videostr$Track;", "", "file", "", "label", "kind", "s", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "getS", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/cncverse/Videostr$Track;", "equals", "other", "hashCode", "", "toString", "Watch32_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Track {

        @Nullable
        private final Boolean default;

        @NotNull
        private final String file;

        @NotNull
        private final String kind;

        @NotNull
        private final String label;

        @NotNull
        private final String s;

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                str3 = track.kind;
            }
            if ((i & 8) != 0) {
                str4 = track.s;
            }
            if ((i & 16) != 0) {
                bool = track.default;
            }
            Boolean bool2 = bool;
            String str5 = str3;
            return track.copy(str, str2, str5, str4, bool2);
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
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getS() {
            return this.s;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getDefault() {
            return this.default;
        }

        @NotNull
        public final Track copy(@NotNull String file, @NotNull String label, @NotNull String kind, @NotNull String s, @Nullable Boolean bool) {
            return new Track(file, label, kind, s, bool);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind) && Intrinsics.areEqual(this.s, track.s) && Intrinsics.areEqual(this.default, track.default);
        }

        public int hashCode() {
            return (((((((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + this.kind.hashCode()) * 31) + this.s.hashCode()) * 31) + (this.default == null ? 0 : this.default.hashCode());
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ", s=" + this.s + ", default=" + this.default + ')';
        }

        public Track(@NotNull String file, @NotNull String label, @NotNull String kind, @NotNull String s, @Nullable Boolean bool) {
            this.file = file;
            this.label = label;
            this.kind = kind;
            this.s = s;
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

        @NotNull
        public final String getKind() {
            return this.kind;
        }

        @NotNull
        public final String getS() {
            return this.s;
        }

        @Nullable
        public final Boolean getDefault() {
            return this.default;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/cncverse/Videostr$Megakey;", "", "rabbit", "", "mega", "vidstr", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRabbit", "()Ljava/lang/String;", "getMega", "getVidstr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Watch32_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Megakey {

        @NotNull
        private final String mega;

        @NotNull
        private final String rabbit;

        @NotNull
        private final String vidstr;

        public static /* synthetic */ Megakey copy$default(Megakey megakey, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = megakey.rabbit;
            }
            if ((i & 2) != 0) {
                str2 = megakey.mega;
            }
            if ((i & 4) != 0) {
                str3 = megakey.vidstr;
            }
            return megakey.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRabbit() {
            return this.rabbit;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMega() {
            return this.mega;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVidstr() {
            return this.vidstr;
        }

        @NotNull
        public final Megakey copy(@NotNull String rabbit, @NotNull String mega, @NotNull String vidstr) {
            return new Megakey(rabbit, mega, vidstr);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Megakey)) {
                return false;
            }
            Megakey megakey = (Megakey) other;
            return Intrinsics.areEqual(this.rabbit, megakey.rabbit) && Intrinsics.areEqual(this.mega, megakey.mega) && Intrinsics.areEqual(this.vidstr, megakey.vidstr);
        }

        public int hashCode() {
            return (((this.rabbit.hashCode() * 31) + this.mega.hashCode()) * 31) + this.vidstr.hashCode();
        }

        @NotNull
        public String toString() {
            return "Megakey(rabbit=" + this.rabbit + ", mega=" + this.mega + ", vidstr=" + this.vidstr + ')';
        }

        public Megakey(@NotNull String rabbit, @NotNull String mega, @NotNull String vidstr) {
            this.rabbit = rabbit;
            this.mega = mega;
            this.vidstr = vidstr;
        }

        @NotNull
        public final String getRabbit() {
            return this.rabbit;
        }

        @NotNull
        public final String getMega() {
            return this.mega;
        }

        @NotNull
        public final String getVidstr() {
            return this.vidstr;
        }
    }
}
