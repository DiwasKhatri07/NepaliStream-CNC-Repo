package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LivXowProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LivXowProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b8\b\u0086\b\u0018\u0000 K2\u00020\u0001:\u0001KBÁ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u00104\u001a\u0004\u0018\u00010\u0003J\b\u00105\u001a\u0004\u0018\u00010\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010C\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010(J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014HÆ\u0003JÈ\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010FJ\u0014\u0010G\u001a\u00020\u00102\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010I\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010J\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b-\u0010\u0018R\u0011\u0010.\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b/\u0010\u0018R\u0013\u00100\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b1\u0010\u0018R\u0011\u00102\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b3\u0010\u0018¨\u0006L"}, d2 = {"Lcom/cncverse/LivXowEvent;", "", "teamAName", "", "teamBName", "teamAFlag", "teamBFlag", "eventName", "eventLogo", "category", "date", "time", "end_date", "end_time", "links", "visible", "", "priority", "", "link_names", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;)V", "getTeamAName", "()Ljava/lang/String;", "getTeamBName", "getTeamAFlag", "getTeamBFlag", "getEventName", "getEventLogo", "getCategory", "getDate", "getTime", "getEnd_date", "getEnd_time", "getLinks", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLink_names", "()Ljava/util/List;", "displayName", "getDisplayName", "categoryName", "getCategoryName", "thumbUrl", "getThumbUrl", "streamSlug", "getStreamSlug", "startTimeString", "endTimeString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;)Lcom/cncverse/LivXowEvent;", "equals", "other", "hashCode", "toString", "Companion", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LivXowEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String category;

    @Nullable
    private final String date;

    @Nullable
    private final String end_date;

    @Nullable
    private final String end_time;

    @Nullable
    private final String eventLogo;

    @Nullable
    private final String eventName;

    @Nullable
    private final List<Object> link_names;

    @Nullable
    private final String links;

    @Nullable
    private final Integer priority;

    @Nullable
    private final String teamAFlag;

    @Nullable
    private final String teamAName;

    @Nullable
    private final String teamBFlag;

    @Nullable
    private final String teamBName;

    @Nullable
    private final String time;

    @Nullable
    private final Boolean visible;

    public LivXowEvent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTeamAName() {
        return this.teamAName;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEnd_time() {
        return this.end_time;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLinks() {
        return this.links;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getVisible() {
        return this.visible;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getPriority() {
        return this.priority;
    }

    @Nullable
    public final List<Object> component15() {
        return this.link_names;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeamBName() {
        return this.teamBName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    @NotNull
    public final LivXowEvent copy(@Nullable String teamAName, @Nullable String teamBName, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventName, @Nullable String eventLogo, @Nullable String category, @Nullable String date, @Nullable String time, @Nullable String end_date, @Nullable String end_time, @Nullable String links, @Nullable Boolean visible, @Nullable Integer priority, @Nullable List<? extends Object> link_names) {
        return new LivXowEvent(teamAName, teamBName, teamAFlag, teamBFlag, eventName, eventLogo, category, date, time, end_date, end_time, links, visible, priority, link_names);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivXowEvent)) {
            return false;
        }
        LivXowEvent livXowEvent = (LivXowEvent) other;
        return Intrinsics.areEqual(this.teamAName, livXowEvent.teamAName) && Intrinsics.areEqual(this.teamBName, livXowEvent.teamBName) && Intrinsics.areEqual(this.teamAFlag, livXowEvent.teamAFlag) && Intrinsics.areEqual(this.teamBFlag, livXowEvent.teamBFlag) && Intrinsics.areEqual(this.eventName, livXowEvent.eventName) && Intrinsics.areEqual(this.eventLogo, livXowEvent.eventLogo) && Intrinsics.areEqual(this.category, livXowEvent.category) && Intrinsics.areEqual(this.date, livXowEvent.date) && Intrinsics.areEqual(this.time, livXowEvent.time) && Intrinsics.areEqual(this.end_date, livXowEvent.end_date) && Intrinsics.areEqual(this.end_time, livXowEvent.end_time) && Intrinsics.areEqual(this.links, livXowEvent.links) && Intrinsics.areEqual(this.visible, livXowEvent.visible) && Intrinsics.areEqual(this.priority, livXowEvent.priority) && Intrinsics.areEqual(this.link_names, livXowEvent.link_names);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.teamAName == null ? 0 : this.teamAName.hashCode()) * 31) + (this.teamBName == null ? 0 : this.teamBName.hashCode())) * 31) + (this.teamAFlag == null ? 0 : this.teamAFlag.hashCode())) * 31) + (this.teamBFlag == null ? 0 : this.teamBFlag.hashCode())) * 31) + (this.eventName == null ? 0 : this.eventName.hashCode())) * 31) + (this.eventLogo == null ? 0 : this.eventLogo.hashCode())) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.time == null ? 0 : this.time.hashCode())) * 31) + (this.end_date == null ? 0 : this.end_date.hashCode())) * 31) + (this.end_time == null ? 0 : this.end_time.hashCode())) * 31) + (this.links == null ? 0 : this.links.hashCode())) * 31) + (this.visible == null ? 0 : this.visible.hashCode())) * 31) + (this.priority == null ? 0 : this.priority.hashCode())) * 31) + (this.link_names != null ? this.link_names.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LivXowEvent(teamAName=").append(this.teamAName).append(", teamBName=").append(this.teamBName).append(", teamAFlag=").append(this.teamAFlag).append(", teamBFlag=").append(this.teamBFlag).append(", eventName=").append(this.eventName).append(", eventLogo=").append(this.eventLogo).append(", category=").append(this.category).append(", date=").append(this.date).append(", time=").append(this.time).append(", end_date=").append(this.end_date).append(", end_time=").append(this.end_time).append(", links=");
        sb.append(this.links).append(", visible=").append(this.visible).append(", priority=").append(this.priority).append(", link_names=").append(this.link_names).append(')');
        return sb.toString();
    }

    public LivXowEvent(@Nullable String teamAName, @Nullable String teamBName, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventName, @Nullable String eventLogo, @Nullable String category, @Nullable String date, @Nullable String time, @Nullable String end_date, @Nullable String end_time, @Nullable String links, @Nullable Boolean visible, @Nullable Integer priority, @Nullable List<? extends Object> list) {
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.teamAFlag = teamAFlag;
        this.teamBFlag = teamBFlag;
        this.eventName = eventName;
        this.eventLogo = eventLogo;
        this.category = category;
        this.date = date;
        this.time = time;
        this.end_date = end_date;
        this.end_time = end_time;
        this.links = links;
        this.visible = visible;
        this.priority = priority;
        this.link_names = list;
    }

    public /* synthetic */ LivXowEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool, Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : bool, (i & 8192) != 0 ? null : num, (i & 16384) == 0 ? list : null);
    }

    @Nullable
    public final String getTeamAName() {
        return this.teamAName;
    }

    @Nullable
    public final String getTeamBName() {
        return this.teamBName;
    }

    @Nullable
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    @Nullable
    public final String getEnd_date() {
        return this.end_date;
    }

    @Nullable
    public final String getEnd_time() {
        return this.end_time;
    }

    @Nullable
    public final String getLinks() {
        return this.links;
    }

    @Nullable
    public final Boolean getVisible() {
        return this.visible;
    }

    @Nullable
    public final Integer getPriority() {
        return this.priority;
    }

    @Nullable
    public final List<Object> getLink_names() {
        return this.link_names;
    }

    @NotNull
    public final String getDisplayName() {
        String str = this.teamAName;
        String a = str != null ? StringsKt.trim(str).toString() : null;
        String str2 = this.teamBName;
        String b = str2 != null ? StringsKt.trim(str2).toString() : null;
        String str3 = a;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            String str4 = b;
            if (!(str4 == null || StringsKt.isBlank(str4)) && !Intrinsics.areEqual(a, b)) {
                return a + " vs " + b;
            }
        }
        String str5 = a;
        if (!(str5 == null || StringsKt.isBlank(str5))) {
            return a;
        }
        String str6 = this.eventName;
        return !(str6 == null || StringsKt.isBlank(str6)) ? this.eventName : "";
    }

    @NotNull
    public final String getCategoryName() {
        String string;
        String str = this.category;
        return (str == null || (string = StringsKt.trim(str).toString()) == null) ? "Sports" : string;
    }

    @Nullable
    public final String getThumbUrl() {
        return this.eventLogo;
    }

    @NotNull
    public final String getStreamSlug() {
        String strRemoveSuffix;
        String str = this.links;
        return (str == null || (strRemoveSuffix = StringsKt.removeSuffix(str, ".txt")) == null) ? "" : strRemoveSuffix;
    }

    @Nullable
    public final String startTimeString() {
        return INSTANCE.toIsoString(this.date, this.time);
    }

    @Nullable
    public final String endTimeString() {
        return INSTANCE.toIsoString(this.end_date, this.end_time);
    }

    /* JADX INFO: compiled from: LivXowProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¨\u0006\b"}, d2 = {"Lcom/cncverse/LivXowEvent$Companion;", "", "<init>", "()V", "toIsoString", "", "date", "time", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final String toIsoString(@Nullable String date, @Nullable String time) {
            if (date == null || time == null) {
                return null;
            }
            List parts = StringsKt.split$default(date, new String[]{"/"}, false, 0, 6, (Object) null);
            if (parts.size() != 3) {
                return null;
            }
            String day = (String) parts.get(0);
            String month = (String) parts.get(1);
            String year = (String) parts.get(2);
            return year + '/' + month + '/' + day + ' ' + time + " +0000";
        }
    }
}
