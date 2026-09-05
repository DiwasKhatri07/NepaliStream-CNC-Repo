package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0003\u0010\f\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J£\u0001\u0010#\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\fHÆ\u0001J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\rHÖ\u0081\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R'\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R'\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R%\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/phisher98/SyncManifest;", "", "extensions", "Lcom/phisher98/SyncCategoryMeta;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "settings", "bookmarks", "resumeWatching", "resume_watching", "searchHistory", "search_history", "version", "", "<init>", "(Lcom/phisher98/SyncCategoryMeta;Lcom/phisher98/SyncCategoryMeta;Lcom/phisher98/SyncCategoryMeta;Lcom/phisher98/SyncCategoryMeta;Lcom/phisher98/SyncCategoryMeta;I)V", "getExtensions", "()Lcom/phisher98/SyncCategoryMeta;", "getSettings", "getBookmarks", "getResumeWatching", "getSearchHistory", "getVersion", "()I", "getMeta", "category", "Lcom/phisher98/SyncCategory;", "withUpdated", "meta", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SyncManifest {

    @JsonProperty("bookmarks")
    @Nullable
    private final SyncCategoryMeta bookmarks;

    @JsonProperty("extensions")
    @Nullable
    private final SyncCategoryMeta extensions;

    @JsonProperty("resume_watching")
    @Nullable
    private final SyncCategoryMeta resumeWatching;

    @JsonProperty("search_history")
    @Nullable
    private final SyncCategoryMeta searchHistory;

    @JsonProperty("settings")
    @Nullable
    private final SyncCategoryMeta settings;

    @JsonProperty("version")
    private final int version;

    /* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SyncCategory.values().length];
            try {
                iArr[SyncCategory.EXTENSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SyncCategory.SETTINGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SyncCategory.BOOKMARKS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SyncCategory.RESUME_WATCHING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SyncCategory.SEARCH_HISTORY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SyncManifest() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ SyncManifest copy$default(SyncManifest syncManifest, SyncCategoryMeta syncCategoryMeta, SyncCategoryMeta syncCategoryMeta2, SyncCategoryMeta syncCategoryMeta3, SyncCategoryMeta syncCategoryMeta4, SyncCategoryMeta syncCategoryMeta5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            syncCategoryMeta = syncManifest.extensions;
        }
        if ((i2 & 2) != 0) {
            syncCategoryMeta2 = syncManifest.settings;
        }
        if ((i2 & 4) != 0) {
            syncCategoryMeta3 = syncManifest.bookmarks;
        }
        if ((i2 & 8) != 0) {
            syncCategoryMeta4 = syncManifest.resumeWatching;
        }
        if ((i2 & 16) != 0) {
            syncCategoryMeta5 = syncManifest.searchHistory;
        }
        if ((i2 & 32) != 0) {
            i = syncManifest.version;
        }
        SyncCategoryMeta syncCategoryMeta6 = syncCategoryMeta5;
        int i3 = i;
        return syncManifest.copy(syncCategoryMeta, syncCategoryMeta2, syncCategoryMeta3, syncCategoryMeta4, syncCategoryMeta6, i3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SyncCategoryMeta getExtensions() {
        return this.extensions;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SyncCategoryMeta getSettings() {
        return this.settings;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SyncCategoryMeta getBookmarks() {
        return this.bookmarks;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SyncCategoryMeta getResumeWatching() {
        return this.resumeWatching;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SyncCategoryMeta getSearchHistory() {
        return this.searchHistory;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public final SyncManifest copy(@JsonProperty("extensions") @Nullable SyncCategoryMeta extensions, @JsonProperty("settings") @Nullable SyncCategoryMeta settings, @JsonProperty("bookmarks") @Nullable SyncCategoryMeta bookmarks, @JsonProperty("resume_watching") @Nullable SyncCategoryMeta resumeWatching, @JsonProperty("search_history") @Nullable SyncCategoryMeta searchHistory, @JsonProperty("version") int version) {
        return new SyncManifest(extensions, settings, bookmarks, resumeWatching, searchHistory, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncManifest)) {
            return false;
        }
        SyncManifest syncManifest = (SyncManifest) other;
        return Intrinsics.areEqual(this.extensions, syncManifest.extensions) && Intrinsics.areEqual(this.settings, syncManifest.settings) && Intrinsics.areEqual(this.bookmarks, syncManifest.bookmarks) && Intrinsics.areEqual(this.resumeWatching, syncManifest.resumeWatching) && Intrinsics.areEqual(this.searchHistory, syncManifest.searchHistory) && this.version == syncManifest.version;
    }

    public int hashCode() {
        return ((((((((((this.extensions == null ? 0 : this.extensions.hashCode()) * 31) + (this.settings == null ? 0 : this.settings.hashCode())) * 31) + (this.bookmarks == null ? 0 : this.bookmarks.hashCode())) * 31) + (this.resumeWatching == null ? 0 : this.resumeWatching.hashCode())) * 31) + (this.searchHistory != null ? this.searchHistory.hashCode() : 0)) * 31) + this.version;
    }

    @NotNull
    public String toString() {
        return "SyncManifest(extensions=" + this.extensions + ", settings=" + this.settings + ", bookmarks=" + this.bookmarks + ", resumeWatching=" + this.resumeWatching + ", searchHistory=" + this.searchHistory + ", version=" + this.version + ')';
    }

    public SyncManifest(@JsonProperty("extensions") @Nullable SyncCategoryMeta extensions, @JsonProperty("settings") @Nullable SyncCategoryMeta settings, @JsonProperty("bookmarks") @Nullable SyncCategoryMeta bookmarks, @JsonProperty("resume_watching") @Nullable SyncCategoryMeta resumeWatching, @JsonProperty("search_history") @Nullable SyncCategoryMeta searchHistory, @JsonProperty("version") int version) {
        this.extensions = extensions;
        this.settings = settings;
        this.bookmarks = bookmarks;
        this.resumeWatching = resumeWatching;
        this.searchHistory = searchHistory;
        this.version = version;
    }

    public /* synthetic */ SyncManifest(SyncCategoryMeta syncCategoryMeta, SyncCategoryMeta syncCategoryMeta2, SyncCategoryMeta syncCategoryMeta3, SyncCategoryMeta syncCategoryMeta4, SyncCategoryMeta syncCategoryMeta5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : syncCategoryMeta, (i2 & 2) != 0 ? null : syncCategoryMeta2, (i2 & 4) != 0 ? null : syncCategoryMeta3, (i2 & 8) != 0 ? null : syncCategoryMeta4, (i2 & 16) != 0 ? null : syncCategoryMeta5, (i2 & 32) != 0 ? 2 : i);
    }

    @Nullable
    public final SyncCategoryMeta getExtensions() {
        return this.extensions;
    }

    @Nullable
    public final SyncCategoryMeta getSettings() {
        return this.settings;
    }

    @Nullable
    public final SyncCategoryMeta getBookmarks() {
        return this.bookmarks;
    }

    @Nullable
    public final SyncCategoryMeta getResumeWatching() {
        return this.resumeWatching;
    }

    @Nullable
    public final SyncCategoryMeta getSearchHistory() {
        return this.searchHistory;
    }

    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @Nullable
    public final SyncCategoryMeta getMeta(@NotNull SyncCategory category) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                return this.extensions;
            case 2:
                return this.settings;
            case 3:
                return this.bookmarks;
            case 4:
                return this.resumeWatching;
            case 5:
                return this.searchHistory;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @NotNull
    public final SyncManifest withUpdated(@NotNull SyncCategory category, @NotNull SyncCategoryMeta meta) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                return copy$default(this, meta, null, null, null, null, 0, 62, null);
            case 2:
                return copy$default(this, null, meta, null, null, null, 0, 61, null);
            case 3:
                return copy$default(this, null, null, meta, null, null, 0, 59, null);
            case 4:
                return copy$default(this, null, null, null, meta, null, 0, 55, null);
            case 5:
                return copy$default(this, null, null, null, null, meta, 0, 47, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
