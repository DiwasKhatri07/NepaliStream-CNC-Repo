package com.anikoto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnikotoExtractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/AniKoto/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/anikoto/MegaPlay;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "MegaPlayResponse", "Sources", "Track", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MegaPlay extends ExtractorApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String name = "MegaPlay";

    @NotNull
    private final String mainUrl = "https://megaplay.buzz";
    private final boolean requiresReferer = true;

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
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

    static /* synthetic */ Object getUrl$suspendImpl(MegaPlay $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        Object objExtractMegaPlayUrl = INSTANCE.extractMegaPlayUrl(url, referer, $this.getMainUrl(), $this.getName(), function1, function2, continuation);
        return objExtractMegaPlayUrl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExtractMegaPlayUrl : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AnikotoExtractors.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\fH\u0086@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/anikoto/MegaPlay$Companion;", "", "<init>", "()V", "extractMegaPlayUrl", "", "url", "", "referer", "host", "serverName", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnikotoExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikotoExtractors.kt\ncom/anikoto/MegaPlay$Companion\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,144:1\n63#2:145\n64#2,15:147\n1#3:146\n50#4:162\n43#4:163\n1915#5,2:164\n1915#5,2:166\n*S KotlinDebug\n*F\n+ 1 AnikotoExtractors.kt\ncom/anikoto/MegaPlay$Companion\n*L\n90#1:145\n90#1:147,15\n90#1:146\n90#1:162\n90#1:163\n102#1:164,2\n113#1:166,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:142:0x073d A[Catch: Exception -> 0x0900, TRY_LEAVE, TryCatch #13 {Exception -> 0x0900, blocks: (B:140:0x0737, B:142:0x073d), top: B:221:0x0737 }] */
        /* JADX WARN: Code duplicated, block: B:146:0x074e  */
        /* JADX WARN: Code duplicated, block: B:147:0x0753  */
        /* JADX WARN: Code duplicated, block: B:160:0x0792 A[Catch: Exception -> 0x08c2, TRY_LEAVE, TryCatch #17 {Exception -> 0x08c2, blocks: (B:150:0x075d, B:157:0x077b, B:160:0x0792, B:164:0x079f), top: B:229:0x075d }] */
        /* JADX WARN: Code duplicated, block: B:162:0x0798  */
        /* JADX WARN: Code duplicated, block: B:168:0x083e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:169:0x083f  */
        /* JADX WARN: Code duplicated, block: B:201:0x0763 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        /* JADX WARN: Path cross not found for [B:201:0x0763, B:157:0x077b], limit reached: 224 */
        /* JADX WARN: Path cross not found for [B:233:0x0564, B:98:0x0579], limit reached: 224 */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x0781 -> B:172:0x0885). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x083f -> B:217:0x086b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object extractMegaPlayUrl(@org.jetbrains.annotations.NotNull java.lang.String r47, @org.jetbrains.annotations.Nullable java.lang.String r48, @org.jetbrains.annotations.NotNull java.lang.String r49, @org.jetbrains.annotations.NotNull java.lang.String r50, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r51, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r52, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r53) {
            /*
                Method dump skipped, instruction units count: 2482
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anikoto.MegaPlay.Companion.extractMegaPlayUrl(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: AnikotoExtractors.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/anikoto/MegaPlay$MegaPlayResponse;", "", "sources", "Lcom/anikoto/MegaPlay$Sources;", "tracks", "", "Lcom/anikoto/MegaPlay$Track;", "<init>", "(Lcom/anikoto/MegaPlay$Sources;Ljava/util/List;)V", "getSources", "()Lcom/anikoto/MegaPlay$Sources;", "getTracks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MegaPlayResponse {

        @JsonProperty("sources")
        @Nullable
        private final Sources sources;

        @JsonProperty("tracks")
        @NotNull
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public MegaPlayResponse() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MegaPlayResponse copy$default(MegaPlayResponse megaPlayResponse, Sources sources, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                sources = megaPlayResponse.sources;
            }
            if ((i & 2) != 0) {
                list = megaPlayResponse.tracks;
            }
            return megaPlayResponse.copy(sources, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Sources getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Track> component2() {
            return this.tracks;
        }

        @NotNull
        public final MegaPlayResponse copy(@JsonProperty("sources") @Nullable Sources sources, @JsonProperty("tracks") @NotNull List<Track> tracks) {
            return new MegaPlayResponse(sources, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MegaPlayResponse)) {
                return false;
            }
            MegaPlayResponse megaPlayResponse = (MegaPlayResponse) other;
            return Intrinsics.areEqual(this.sources, megaPlayResponse.sources) && Intrinsics.areEqual(this.tracks, megaPlayResponse.tracks);
        }

        public int hashCode() {
            return ((this.sources == null ? 0 : this.sources.hashCode()) * 31) + this.tracks.hashCode();
        }

        @NotNull
        public String toString() {
            return "MegaPlayResponse(sources=" + this.sources + ", tracks=" + this.tracks + ')';
        }

        public MegaPlayResponse(@JsonProperty("sources") @Nullable Sources sources, @JsonProperty("tracks") @NotNull List<Track> list) {
            this.sources = sources;
            this.tracks = list;
        }

        public /* synthetic */ MegaPlayResponse(Sources sources, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : sources, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        @Nullable
        public final Sources getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Track> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: AnikotoExtractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/anikoto/MegaPlay$Sources;", "", "file", "", "<init>", "(Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Sources {

        @JsonProperty("file")
        @Nullable
        private final String file;

        /* JADX WARN: Illegal instructions before constructor call */
        public Sources() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ Sources copy$default(Sources sources, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sources.file;
            }
            return sources.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @NotNull
        public final Sources copy(@JsonProperty("file") @Nullable String file) {
            return new Sources(file);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Sources) && Intrinsics.areEqual(this.file, ((Sources) other).file);
        }

        public int hashCode() {
            if (this.file == null) {
                return 0;
            }
            return this.file.hashCode();
        }

        @NotNull
        public String toString() {
            return "Sources(file=" + this.file + ')';
        }

        public Sources(@JsonProperty("file") @Nullable String file) {
            this.file = file;
        }

        public /* synthetic */ Sources(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }
    }

    /* JADX INFO: compiled from: AnikotoExtractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/anikoto/MegaPlay$Track;", "", "file", "", "label", "kind", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Track {

        @JsonProperty("file")
        @Nullable
        private final String file;

        @JsonProperty("kind")
        @Nullable
        private final String kind;

        @JsonProperty("label")
        @Nullable
        private final String label;

        public Track() {
            this(null, null, null, 7, null);
        }

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

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        @NotNull
        public final Track copy(@JsonProperty("file") @Nullable String file, @JsonProperty("label") @Nullable String label, @JsonProperty("kind") @Nullable String kind) {
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
            return ((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind != null ? this.kind.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Track(@JsonProperty("file") @Nullable String file, @JsonProperty("label") @Nullable String label, @JsonProperty("kind") @Nullable String kind) {
            this.file = file;
            this.label = label;
            this.kind = kind;
        }

        public /* synthetic */ Track(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getKind() {
            return this.kind;
        }
    }
}
