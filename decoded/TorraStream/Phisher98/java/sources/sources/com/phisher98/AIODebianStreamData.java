package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jª\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010:J\u0014\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020>HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018¨\u0006@"}, d2 = {"Lcom/phisher98/AIODebianStreamData;", "", "type", "", "proxied", "", "indexer", "duration", "", "library", "size", "torrent", "Lcom/phisher98/AIODebianTorrent;", "addon", "filename", "service", "Lcom/phisher98/Service;", "parsedFile", "Lcom/phisher98/ParsedFile;", "id", "folderName", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/phisher98/AIODebianTorrent;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/Service;Lcom/phisher98/ParsedFile;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getProxied", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIndexer", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLibrary", "getSize", "getTorrent", "()Lcom/phisher98/AIODebianTorrent;", "getAddon", "getFilename", "getService", "()Lcom/phisher98/Service;", "getParsedFile", "()Lcom/phisher98/ParsedFile;", "getId", "getFolderName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/phisher98/AIODebianTorrent;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/Service;Lcom/phisher98/ParsedFile;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/AIODebianStreamData;", "equals", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AIODebianStreamData {

    @Nullable
    private final String addon;

    @Nullable
    private final Long duration;

    @Nullable
    private final String filename;

    @Nullable
    private final String folderName;

    @Nullable
    private final String id;

    @Nullable
    private final String indexer;

    @Nullable
    private final Boolean library;

    @Nullable
    private final ParsedFile parsedFile;

    @Nullable
    private final Boolean proxied;

    @Nullable
    private final Service service;

    @Nullable
    private final Long size;

    @Nullable
    private final AIODebianTorrent torrent;

    @Nullable
    private final String type;

    public AIODebianStreamData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ AIODebianStreamData copy$default(AIODebianStreamData aIODebianStreamData, String str, Boolean bool, String str2, Long l, Boolean bool2, Long l2, AIODebianTorrent aIODebianTorrent, String str3, String str4, Service service, ParsedFile parsedFile, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aIODebianStreamData.type;
        }
        return aIODebianStreamData.copy(str, (i & 2) != 0 ? aIODebianStreamData.proxied : bool, (i & 4) != 0 ? aIODebianStreamData.indexer : str2, (i & 8) != 0 ? aIODebianStreamData.duration : l, (i & 16) != 0 ? aIODebianStreamData.library : bool2, (i & 32) != 0 ? aIODebianStreamData.size : l2, (i & 64) != 0 ? aIODebianStreamData.torrent : aIODebianTorrent, (i & 128) != 0 ? aIODebianStreamData.addon : str3, (i & 256) != 0 ? aIODebianStreamData.filename : str4, (i & 512) != 0 ? aIODebianStreamData.service : service, (i & 1024) != 0 ? aIODebianStreamData.parsedFile : parsedFile, (i & 2048) != 0 ? aIODebianStreamData.id : str5, (i & 4096) != 0 ? aIODebianStreamData.folderName : str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Service getService() {
        return this.service;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ParsedFile getParsedFile() {
        return this.parsedFile;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getProxied() {
        return this.proxied;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIndexer() {
        return this.indexer;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getLibrary() {
        return this.library;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final AIODebianTorrent getTorrent() {
        return this.torrent;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAddon() {
        return this.addon;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    @NotNull
    public final AIODebianStreamData copy(@Nullable String type, @Nullable Boolean proxied, @Nullable String indexer, @Nullable Long duration, @Nullable Boolean library, @Nullable Long size, @Nullable AIODebianTorrent torrent, @Nullable String addon, @Nullable String filename, @Nullable Service service, @Nullable ParsedFile parsedFile, @Nullable String id, @Nullable String folderName) {
        return new AIODebianStreamData(type, proxied, indexer, duration, library, size, torrent, addon, filename, service, parsedFile, id, folderName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIODebianStreamData)) {
            return false;
        }
        AIODebianStreamData aIODebianStreamData = (AIODebianStreamData) other;
        return Intrinsics.areEqual(this.type, aIODebianStreamData.type) && Intrinsics.areEqual(this.proxied, aIODebianStreamData.proxied) && Intrinsics.areEqual(this.indexer, aIODebianStreamData.indexer) && Intrinsics.areEqual(this.duration, aIODebianStreamData.duration) && Intrinsics.areEqual(this.library, aIODebianStreamData.library) && Intrinsics.areEqual(this.size, aIODebianStreamData.size) && Intrinsics.areEqual(this.torrent, aIODebianStreamData.torrent) && Intrinsics.areEqual(this.addon, aIODebianStreamData.addon) && Intrinsics.areEqual(this.filename, aIODebianStreamData.filename) && Intrinsics.areEqual(this.service, aIODebianStreamData.service) && Intrinsics.areEqual(this.parsedFile, aIODebianStreamData.parsedFile) && Intrinsics.areEqual(this.id, aIODebianStreamData.id) && Intrinsics.areEqual(this.folderName, aIODebianStreamData.folderName);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.proxied == null ? 0 : this.proxied.hashCode())) * 31) + (this.indexer == null ? 0 : this.indexer.hashCode())) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.library == null ? 0 : this.library.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.torrent == null ? 0 : this.torrent.hashCode())) * 31) + (this.addon == null ? 0 : this.addon.hashCode())) * 31) + (this.filename == null ? 0 : this.filename.hashCode())) * 31) + (this.service == null ? 0 : this.service.hashCode())) * 31) + (this.parsedFile == null ? 0 : this.parsedFile.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.folderName != null ? this.folderName.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AIODebianStreamData(type=").append(this.type).append(", proxied=").append(this.proxied).append(", indexer=").append(this.indexer).append(", duration=").append(this.duration).append(", library=").append(this.library).append(", size=").append(this.size).append(", torrent=").append(this.torrent).append(", addon=").append(this.addon).append(", filename=").append(this.filename).append(", service=").append(this.service).append(", parsedFile=").append(this.parsedFile).append(", id=");
        sb.append(this.id).append(", folderName=").append(this.folderName).append(')');
        return sb.toString();
    }

    public AIODebianStreamData(@Nullable String type, @Nullable Boolean proxied, @Nullable String indexer, @Nullable Long duration, @Nullable Boolean library, @Nullable Long size, @Nullable AIODebianTorrent torrent, @Nullable String addon, @Nullable String filename, @Nullable Service service, @Nullable ParsedFile parsedFile, @Nullable String id, @Nullable String folderName) {
        this.type = type;
        this.proxied = proxied;
        this.indexer = indexer;
        this.duration = duration;
        this.library = library;
        this.size = size;
        this.torrent = torrent;
        this.addon = addon;
        this.filename = filename;
        this.service = service;
        this.parsedFile = parsedFile;
        this.id = id;
        this.folderName = folderName;
    }

    public /* synthetic */ AIODebianStreamData(String str, Boolean bool, String str2, Long l, Boolean bool2, Long l2, AIODebianTorrent aIODebianTorrent, String str3, String str4, Service service, ParsedFile parsedFile, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : aIODebianTorrent, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : service, (i & 1024) != 0 ? null : parsedFile, (i & 2048) != 0 ? null : str5, (i & 4096) == 0 ? str6 : null);
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Boolean getProxied() {
        return this.proxied;
    }

    @Nullable
    public final String getIndexer() {
        return this.indexer;
    }

    @Nullable
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    public final Boolean getLibrary() {
        return this.library;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    public final AIODebianTorrent getTorrent() {
        return this.torrent;
    }

    @Nullable
    public final String getAddon() {
        return this.addon;
    }

    @Nullable
    public final String getFilename() {
        return this.filename;
    }

    @Nullable
    public final Service getService() {
        return this.service;
    }

    @Nullable
    public final ParsedFile getParsedFile() {
        return this.parsedFile;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getFolderName() {
        return this.folderName;
    }
}
